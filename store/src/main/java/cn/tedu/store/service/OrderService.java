package cn.tedu.store.service;

import cn.tedu.store.entity.Order;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:39:19
 * @description 描述：出路订单和订单商品的业务层接口
 */
public interface OrderService {

	/**
	 * 创建订单
	 * 
	 * @param aid      收货地址数据的id
	 * @param cids     需要购买的购物车商品数据id
	 * @param uid      用户的id
	 * @param username 用户名
	 * @return 返回成功创建的订单对象
	 */
	Order createOrder(Integer aid, Integer[] cids, Integer uid, String username);

}
