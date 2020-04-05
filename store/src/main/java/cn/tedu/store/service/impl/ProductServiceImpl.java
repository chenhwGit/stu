package cn.tedu.store.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Product;
import cn.tedu.store.mapper.ProductMapper;
import cn.tedu.store.service.ProductService;
import cn.tedu.store.service.ex.ProductNotFoundException;
import cn.tedu.store.service.ex.ProductOutOfStockException;
import cn.tedu.store.service.ex.UpdateException;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:40:24
 * @description 描述：
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;

	@Override
	public void reduceNum(Integer id, Integer amount, String username) {
		// 基于参数id调用findById()查询商品数据
		Product result = findById(id);
		// 判断查询结果是否为null
		if (result == null) {
			// 是：抛出 ProductNotFoundException
			throw new ProductNotFoundException("减少商品库存失败！尝试访问的数据不存在！");
		}

		// 通过查询结果可以得到原库存值，结合参数amount，计算得到新的库存值
		Integer num = result.getNum() - amount;
		// 判断新的库存值是否<0
		if (num < 0) {
			// 是：抛出ProductOutOfStockException
			throw new ProductOutOfStockException("更新商品库存失败！商品库存不足！");
		}

		// 调用updateNumById()更新商品的库存
		updateNumById(id, num, username, new Date());
	}

	@Override
	public List<Product> getHotList() {
		// 调用私有方法查询得到列表
		List<Product> list = findHotList();
		// 遍历列表，将不需要响应给客户端的数据属性设置为null
		for (Product product : list) {
			product.setCategoryId(null);
			product.setImage(null);
			product.setStatus(null);
			product.setPriority(null);
			product.setCreatedUser(null);
			product.setCreatedTime(null);
			product.setModifiedUser(null);
			product.setModifiedTime(null);
		}
		// 返回列表
		return list;
	}

	@Override
	public Product getById(Integer id) {
		// 调用自身私有方法查询数据
		Product product = findById(id);
		// 检查查询结果数据是否为null
		if (product == null) {
			// 是：抛出ProductNotFoundException
			throw new ProductNotFoundException("查询商品信息失败！您尝试查询的商品不存在！");
		}

		// 将不必要响应给客户端的属性值设为null
		product.setCategoryId(null);
		product.setStatus(null);
		product.setPriority(null);
		product.setCreatedUser(null);
		product.setCreatedTime(null);
		product.setModifiedUser(null);
		product.setModifiedTime(null);
		// 返回数据
		return product;
	}

	/**
	 * 查找商品
	 * 
	 * @param id 商品id
	 * @return 商品数据信息
	 */
	private Product findById(Integer id) {
		return productMapper.findById(id);
	}

	/**
	 * 修改库存
	 * 
	 * @param id 商品id
	 * @return 受影响的行数
	 */
	private void updateNumById(Integer id, Integer num, String modifiedUser, Date modifiedTime) {
		Integer rows = productMapper.updateNumById(id, num, modifiedUser, modifiedTime);
		if (rows != 1) {
			throw new UpdateException("库存修改失败！出现未知原因！请及时联系商品管理员！");
		}
	}

	/**
	 * 查询热销排行
	 * 
	 * @return 返回热销排行的数据集
	 */
	private List<Product> findHotList() {
		return productMapper.findHotList();
	}

}
