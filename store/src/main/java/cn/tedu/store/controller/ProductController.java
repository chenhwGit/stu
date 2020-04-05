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
import cn.tedu.store.entity.Product;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.ProductService;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController {
	@Autowired
	private ProductService productService;

	// http://localhost:8080/products/list/hot
	@GetMapping("list/hot")
	public JsonResult<List<Product>> getHotList() {
		List<Product> data = productService.getHotList();
		return new JsonResult<>(OK, data);
	}

	// http://localhost:8080/products/10000017/details
	@GetMapping("{id}/details")
	public JsonResult<Product> getById(@PathVariable("id") Integer id) {
		Product data = productService.getById(id);
		return new JsonResult<>(OK, data);
	}

}
