package cn.tedu.store.mapper;

import cn.tedu.store.entity.Order;
import cn.tedu.store.entity.OrderItem;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午11:46:16
 * @description 描述：订单的持久层接口
 */
public interface OrderMapper {
	/**
	 * 插入订单数据
	 * 
	 * @param order 订单数据
	 * @return 受影响的行数
	 */
	Integer insertOrder(Order order);

	/**
	 * 插入订单商品数据
	 * 
	 * @param orderItem 订单商品数据
	 * @return 受影响的行数
	 */
	Integer insertOrderItem(OrderItem orderItem);
}
