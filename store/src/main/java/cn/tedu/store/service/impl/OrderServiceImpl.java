package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Cart;
import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;
import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.CartService;
import cn.tedu.store.service.OrderService;
import cn.tedu.store.service.ProductService;
import cn.tedu.store.service.ex.AccessDeniedException;
import cn.tedu.store.service.ex.CartNotFoundException;
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
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;

	@Override
	public Order createOrder(Integer aid, Integer[] cids, Integer uid, String username) {
		// 创建当前时间对象now
		Date now = new Date();
		// 根据参数aid调用addressService.getByAid()查询收货地址详情
		Address address = addressService.getByAid(aid);
		// 根据参数cids调用cartService.getByCids()，得到List<CartVO>
		List<CartVO> list = cartService.getByCids(cids, uid);
		// 定义totalPrice变量
		Integer totalPrice = 0;
		// 遍历以上查询到的List<CartVO>，计算出totalPrice
		for (CartVO cartVO : list) {
			totalPrice += cartVO.getNum() * cartVO.getRealPrice();
		}

		// 创建Order对象
		Order order = new Order();
		// 补全Order对象中的属性：uid > 参数uid
		order.setUid(uid);
		// 补全Order对象中的属性：recv* > 收货地址详情
		order.setRecvName(address.getName());
		order.setRecvProvince(address.getProvinceName());
		order.setRecvCity(address.getCityName());
		order.setRecvArea(address.getAreaName());
		order.setRecvAddress(address.getAddress());
		// 补全Order对象中的属性：orderTime > now
		order.setOrderTime(now);
		// 补全Order对象中的属性：payTime > null
		order.setPayTime(null);
		// 补全Order对象中的属性：totalPrice > totalPrice
		order.setTotalPrice(totalPrice);
		// 补全Order对象中的属性：status > 0
		order.setStatus(0);
		// 补全Order对象中的属性：4个日志
		order.setCreatedUser(username);
		order.setCreatedTime(now);
		order.setModifiedUser(username);
		order.setModifiedTime(now);
		// 调用insertOrder(Order order)插入订单数据
		insertOrder(order);
		// 遍历查询到的List<CartVO>
		for (CartVO cartVO : list) {
			// -- 创建OrderItem对象
			OrderItem orderItem = new OrderItem();
			// -- 补全OrderItem对象中的属性：oid > order.getOid();
			orderItem.setOid(order.getOid());
			// -- 补全OrderItem对象中的属性：pid, title, image, price, num > CartVO对象中的属性
			orderItem.setPid(cartVO.getPid());
			orderItem.setTitle(cartVO.getTitle());
			orderItem.setImage(cartVO.getImage());
			orderItem.setPrice(cartVO.getRealPrice());
			orderItem.setNum(cartVO.getNum());
			// -- 补全OrderItem对象中的属性：4个日志
			orderItem.setCreatedUser(username);
			orderItem.setCreatedTime(now);
			orderItem.setModifiedUser(username);
			orderItem.setModifiedTime(now);
			// -- 多次调用insertOrderItem(OrderItem orderItem)插入订单商品数据
			insertOrderItem(orderItem);
			// 减去商品的库存
			productService.reduceNum(cartVO.getPid(), cartVO.getNum(), username);
		}

		// 删除购物车对应的数据
		cartService.delete(cids, uid);

		// (考虑)后续还需要归还的库存

		// 返回订单数据
		Order result = new Order();
		result.setOid(order.getOid());
		result.setTotalPrice(order.getTotalPrice());
		return result;
	}

	/**
	 * 插入订单数据
	 * 
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	private void insertOrder(Order order) {
		Integer rows = orderMapper.insertOrder(order);
		if (rows != 1) {
			throw new InsertException("创建订单失败！插入订单数据时出现未知错误，请联系系统管理员！");
		}

	}

	/**
	 * 插入订单商品数据
	 * 
	 * @param orderItem 订单商品数据
	 * @return 受影响的行数
	 */
	private void insertOrderItem(OrderItem orderItem) {
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if (rows != 1) {
			throw new InsertException("添加订单商品失败！插入订单商品数据时出现未知错误，请联系系统管理员！");
		}
	}

}
