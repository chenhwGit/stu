package cn.tedu.db.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.db.common.pojo.JsonResult;
import cn.tedu.db.sys.pojo.MenuNodeVO;
import cn.tedu.db.sys.pojo.SysMenuDO;
import cn.tedu.db.sys.service.ISysMenuService;

@RestController
@RequestMapping("/menu")
public class SysMenuController {

	@Autowired
	ISysMenuService service;

	@GetMapping("/findMenuNode")
	public JsonResult<List<MenuNodeVO>> findMenuNode() {
		List<MenuNodeVO> data = service.findMenuNode();
		return JsonResult.getSuccessJR(data);
	}

	@PostMapping("/saveSysMenu")
	public JsonResult<Void> saveSysMenu(SysMenuDO sysMenuDO) {
		service.saveSysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}

	@PostMapping("/removeSysMenu")
	public JsonResult<Void> removeSysMenu(Integer menuId) {
		service.removeSysMenu(menuId);
		return JsonResult.getSuccessJR();
	}

	@RequestMapping("/findSysMenu")
	public JsonResult<List<SysMenuDO>> findSysMenu() {
		List<SysMenuDO> list = service.findSysMenu();
		return JsonResult.getSuccessJR(list);
	}

	// localhost:8080/menu/findSysMenuById?id=135
	@RequestMapping("/findSysMenuById")
	public JsonResult<SysMenuDO> findSysMenuById(Integer id) {
		SysMenuDO data = service.findSysMenuById(id);
		return JsonResult.getSuccessJR(data);
	}

	// localhost:8080/menu/modifySysMenu?id=135&name=test123&parentId=24
	@RequestMapping("/modifySysMenu")
	public JsonResult<Void> modifyMenu(SysMenuDO sysMenuDO) {
		service.modifySysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}

}
