package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.ProductService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
import cn.tedu.store.service.ex.DeleteException;
import cn.tedu.store.service.ex.InsertException;
import cn.tedu.store.service.ex.UpdateException;
import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:40:24
 * @description 描述：
 */
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private ProductService productService;

	@Override
	public void addToCart(Integer uid, String username, Integer pid, Integer amount) {
		// 日志
		System.err.println("CartServiceImpl.addToCart()");
		// 创建当前时间对象now
		Date now = new Date();
		// 调用findByUidAndPid()查询购物车详情
		Cart result = findByUidAndPid(uid, pid);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：表示该用户的购物车没有该商品，则需要执行insert操作
			// -- 调用productService.getById()得到商品详情，该数据中包含商品价格
			Product product = productService.getById(pid);
			// -- 创建新的Cart对象
			Cart cart = new Cart();
			// -- 补全Cart对象的属性：uid > 参数uid
			cart.setUid(uid);
			// -- 补全Cart对象的属性：pid > 参数pid
			cart.setPid(pid);
			// -- 补全Cart对象的属性：num > 参数amount
			cart.setNum(amount);
			// -- 补全Cart对象的属性：price > 以上查询到的商品详情中包含价格
			cart.setPrice(product.getPrice());
			// -- 补全Cart对象的属性：4个日志 > 参数username, now
			cart.setCreatedUser(username);
			cart.setCreatedTime(now);
			cart.setModifiedUser(username);
			cart.setModifiedTime(now);
			// -- 调用insert()插入数据
			insert(cart);
		} else {
			// 否：表示该用户的购物车已有该商品，则需要执行update操作增加数量
			// -- 从查询结果中获取cid
			Integer cid = result.getCid();
			// -- 从查询结果中取出原有数量，与参数amount相加，得到新的数量
			Integer num = result.getNum() + amount;
			// -- 调用updateNumByCid()执行修改数量
			updateNumByCid(cid, num, username, now);
		}
	}

	@Override
	public void delete(Integer[] cids, Integer uid) {
		deleteBycids(cids, uid);
	}

	@Override
	public List<CartVO> getByUid(Integer uid) {
		List<CartVO> list = findByUid(uid);
		return list;
	}

	@Override
	public void addNum(Integer cid, Integer uid, String username) {
		// 根据参数cid调用findByCid()查询购物车详情数据
		Cart cart = findByCid(cid);
		// 判断查询结果是否为null
		if (cart == null) {
			// 是：抛出CartNotFoundException
			throw new CartNotFoundException("增加购物车商品数据失败！您尝试访问的购物车数据不存在!");
		}

		// 判断查询结果中的uid与参数uid是否不匹配
		if (!uid.equals(cart.getUid())) {
			// 是：抛出AccessDeniedException
			throw new AccessDeniedException("增加购物车商品数据失败！非法访问已经被拒绝!");
		}

		// 从查询结果中取出原数量，增加1，得到新的数量
		Integer num = cart.getNum() + 1;
		// 判断自定义规则：新的数量应该在哪个范围之内
		if (num >= 1 && num <= 5) {
			// 调用updateNumByCid()执行更新数量
			updateNumByCid(cid, num, username, new Date());
		}
	}

	@Override
	public void reduceNum(Integer cid, Integer uid, String username) {
		// 根据参数cid调用findByCid()查询购物车详情数据
		Cart cart = findByCid(cid);
		// 判断查询结果是否为null
		if (cart == null) {
			// 是：抛出CartNotFoundException
			throw new CartNotFoundException("减少购物车商品数据失败！您尝试访问的购物车数据不存在!");
		}

		// 判断查询结果中的uid与参数uid是否不匹配
		if (!uid.equals(cart.getUid())) {
			// 是：抛出AccessDeniedException
			throw new AccessDeniedException("减少购物车商品数据失败！非法访问已经被拒绝!");
		}

		// 从查询结果中取出原数量减少1，得到新的数量
		Integer num = cart.getNum() - 1;
		// 判断自定义规则：新的数量应该在哪个范围之内
		if (num > 1) {
			// 调用updateNumByCid()执行更新数量
			updateNumByCid(cid, num, username, new Date());
		}

	}

	@Override
	public List<CartVO> getByCids(Integer[] cids, Integer uid) {
		// 调用findByCids(cids)执行查询，得到列表数据
		List<CartVO> list = findByCids(cids);
		// -----------------
		// 从列表中移除非当前登录用户的数据：在遍历过程中移除集合中的元素，需要使用迭代器
		Iterator<CartVO> iterator = list.iterator();
		while (iterator.hasNext()) {
			if (!iterator.next().getUid().equals(uid)) {
				iterator.remove();
			}
		}
		// -----------------

		// 返回列表
		return list;
	}

	/**
	 * 添加商品
	 * 
	 * @param cart 商品信息
	 * @return 受影响的行数
	 */
	private void insert(Cart cart) {
		Integer rows = cartMapper.insert(cart);
		if (rows != 1) {
			throw new InsertException("添加商品信息失败！出现未知原因！请及时联系商品管理员！");
		}
	}

	/**
	 * 删除某用户的若干个购物车数据
	 * 
	 * @param cids 若干个数据id
	 * @param uid  用户归属id
	 * @return 受影响的行数
	 */
	private void deleteBycids(Integer[] cids, Integer uid) {
		Integer rows = cartMapper.deleteBycids(cids, uid);
		if (rows < 1) {
			throw new DeleteException("删除购物车数据失败！出现未知原因！请及时联系购物车管理员！");
		}

	}

	/**
	 * 修改商品数量
	 * 
	 * @param cid          购物车数据id
	 * @param num          商品的数量
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时时间
	 * @return 受影响的行数
	 */
	private void updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime) {
		Integer rows = cartMapper.updateNumByCid(cid, num, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("更新购物车商品数量失败！出现未知原因！请及时联系商品管理员！");
		}
	}

	/**
	 * 根据归属用户的id和商品的id查找相应的商品信息
	 * 
	 * @param uid 归属用户的id
	 * @param pid 商品的id
	 * @return 商品信息数据
	 */
	private Cart findByUidAndPid(Integer uid, Integer pid) {
		return cartMapper.findByUidAndPid(uid, pid);
	}

	/**
	 * 根据用户id查询购物车商品信息
	 * 
	 * @param uid 用户id
	 * @return 返回用户购物车信息
	 */
	private List<CartVO> findByUid(Integer uid) {
		return cartMapper.findByUid(uid);
	}

	/**
	 * 
	 * @param cid 购物车id
	 * @param uid 用户id
	 */

	/**
	 * 根据购物车数据的id查询购物车详情
	 * 
	 * @param cid 购物车数据的id
	 * @return 匹配的购物车详情
	 */
	private Cart findByCid(Integer cid) {
		return cartMapper.findByCid(cid);
	}

	/**
	 * 查询若干个数据id匹配的购物车列表
	 * 
	 * @param cids 若干个数据id
	 * @return 匹配的购物车列表
	 */
	private List<CartVO> findByCids(Integer[] cids) {
		return cartMapper.findByCids(cids);
	}

}
