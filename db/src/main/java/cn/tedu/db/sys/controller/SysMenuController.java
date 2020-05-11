package cn.tedu.db.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.db.common.pojo.JsonResult;
import cn.tedu.db.sys.pojo.MenuNodeVO;
import cn.tedu.db.sys.pojo.SysMenuDO;
import cn.tedu.db.sys.service.ISysMenuService;

@RestController
@RequestMapping("/menu")
public class SysMenuController{

	@Autowired	
	ISysMenuService service;
	
	@RequestMapping("/findSysMenuById")
	public JsonResult<SysMenuDO> findSysMenuById(Integer menuId){
		SysMenuDO data=service.findSysMenuById(menuId);
		return JsonResult.getSuccessJR(data);
	}

	@PostMapping("/modifySysMenu")
	public JsonResult<Void> modifySysMenu(SysMenuDO sysMenuDO){
		service.modifySysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}
	
	@RequestMapping("/findMenuNode")
	public JsonResult<List<MenuNodeVO>> findMenuNode(){
		List<MenuNodeVO> data=service.findMenuNode();
		return JsonResult.getSuccessJR(data);
	}

	@RequestMapping("/saveSysMenu")
	public JsonResult<Void> saveSysMenu(SysMenuDO sysMenuDO){
		service.saveSysMenu(sysMenuDO);
		return JsonResult.getSuccessJR();
	}
	
	@PostMapping("/removeSysMenu")
	public JsonResult<Void> removeSysMenu(Integer menuId){
		service.removeSysMenu(menuId);
		return JsonResult.getSuccessJR();
	}

	@RequestMapping("/findSysMenu")
	public JsonResult<List<SysMenuDO>> findSysMenu(){
		List<SysMenuDO> list=service.findSysMenu();
		return JsonResult.getSuccessJR(list);
	}

}
