package cn.tedu.store.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.Address;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
	@Autowired
	private AddressService addressService;

	// http:localhost:8089/addresses/addnew?name=Alex
	@RequestMapping("addnew")
	public JsonResult<Void> addnew(Address address, HttpSession session) {
		// 从session中获取uid和username
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		// 调用业务对象的方法
		addressService.addnew(uid, username, address);
		// 响应成功
		return new JsonResult<>(OK);
	}

	// http:localhost:8089/addresses
	@GetMapping({ "", "/" })
	public JsonResult<List<Address>> getByUid(HttpSession session) {
		Integer uid = getUidFromSession(session);
		List<Address> data = addressService.getByUid(uid);
		return new JsonResult<>(OK, data);
	}

	// http:localhost:8080/addresses/12/set_default
	@RequestMapping("{aid}/set_default")
	public JsonResult<Void> updateDefaultByAid(@PathVariable("aid") Integer aid, HttpSession session) {
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.setDefault(aid, uid, username);
		return new JsonResult<>(OK);
	}

	// http:localhost:8080/addresses/12/delete
	@RequestMapping("{aid}/delete")
	public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session) {
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		addressService.delete(aid, uid, username);
		return new JsonResult<>(OK);
	}

}
