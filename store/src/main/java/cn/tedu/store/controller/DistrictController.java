package cn.tedu.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.store.entity.District;
import cn.tedu.store.service.DistrictService;
import cn.tedu.store.util.JsonResult;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:11:40
 * @description 描述：
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController {
	@Autowired
	private DistrictService districtService;

	// http://localhost:8089/districts/parent=86
	// http://localhost:8089/districts/?parent=86
	@GetMapping({ "", "/" })
	public JsonResult<List<District>> getByParrnt(String parent) {
		List<District> data = districtService.getByParent(parent);
		return new JsonResult<>(OK, data);
	}

}
