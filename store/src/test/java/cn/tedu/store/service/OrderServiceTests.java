package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.ex.ServiceException;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午12:20:26
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTests {

	@Autowired
	private OrderService orderService;

	@Test
	public void createOrder() {
		try {
			Integer aid = 25;
			Integer[] cids = { 2, 8, 10, 18, 20 };
			Integer uid = 21;
			String username = "订单管理员";
			Order order = orderService.createOrder(aid, cids, uid, username);
			System.err.println("ok");
			System.err.println(order);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

}
