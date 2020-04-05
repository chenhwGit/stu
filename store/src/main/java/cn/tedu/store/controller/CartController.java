package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.service.CartService;
import cn.tedu.store.util.JsonResult;
import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController {
	@Autowired
	private CartService cartService;

	// http://localhost:8080/carts/add?pid=10000017&amount=3
	@RequestMapping("add")
	public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session) {
		// 从Session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		// 调用业务方法执行功能
		cartService.addToCart(uid, username, pid, amount);
		// 响应成功
		return new JsonResult<>(OK);
	}

	// http://localhost:8080/carts/
	@GetMapping({ "", "/" })
	public JsonResult<List<CartVO>> getByUid(HttpSession session) {
		// 从Session中获取uid
		Integer uid = getUidFromSession(session);
		// 执行查询，获取数据
		List<CartVO> data = cartService.getByUid(uid);
		// 返回成功与数据
		return new JsonResult<>(OK, data);
	}

	// http://localhost:8080/carts/11/num/add
	@RequestMapping("{cid}/num/add")
	public JsonResult<Void> addNum(@PathVariable("cid") Integer cid, HttpSession session) {
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		cartService.addNum(cid, uid, username);
		// 返回成功与数据
		return new JsonResult<>(OK);
	}

	// http://localhost:8080/carts/11/num/reduce
	@RequestMapping("{cid}/num/reduce")
	public JsonResult<Void> reduceNum(@PathVariable("cid") Integer cid, HttpSession session) {
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		cartService.reduceNum(cid, uid, username);
		// 返回成功与数据
		return new JsonResult<>(OK);
	}

	// http://localhost:8080/carts/get_by_cids?cids=2&cids=8&cids=15&cids=16&cids=18&cids=20
	@GetMapping("get_by_cids")
	public JsonResult<List<CartVO>> getByCids(Integer[] cids, HttpSession session) {
		Integer uid = getUidFromSession(session);
		List<CartVO> data = cartService.getByCids(cids, uid);
		// 返回成功与数据
		return new JsonResult<>(OK, data);
	}

}
