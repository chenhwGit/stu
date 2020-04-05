package cn.tedu.store.service;

import java.util.Date;
import java.util.List;

import cn.tedu.store.entity.Product;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:39:19
 * @description 描述：
 */
public interface ProductService {

	/**
	 * 减少商品的库存
	 * 
	 * @param id       商品的id
	 * @param amount   减少的数量
	 * @param username 用户名
	 */
	void reduceNum(Integer id, Integer amount, String username);

	/**
	 * 查询热销商品
	 * 
	 * @return 热销商品数据集
	 */
	List<Product> getHotList();

	/**
	 * 查找商品
	 * 
	 * @param id 商品id
	 * @return 商品数据信息
	 */
	Product getById(Integer id);
}
