package cn.tedu.store.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Order;
import cn.tedu.store.service.OrderService;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {
	@Autowired
	private OrderService orderService;

	// http://localhost:8080/orders/create?aid=25&cids=2&cids=15&cids=16&cids=18&cids=20
	@RequestMapping("create")
	public JsonResult<Order> getByCids(Integer aid, Integer[] cids, HttpSession session) {
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		Order data = orderService.createOrder(aid, cids, uid, username);
		// 返回成功与数据
		return new JsonResult<>(OK, data);
	}

}
