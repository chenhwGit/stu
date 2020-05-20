package cn.tedu.db.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.db.common.pojo.JsonResult;
import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysRoleDO;
import cn.tedu.db.sys.service.ISysRoleService;

@RestController
@RequestMapping("/role")
public class SysRoleController{
	
	@Autowired
	ISysRoleService service;
	
	@RequestMapping("/findAllSysRole")
	public JsonResult<List<SysRoleDO>> findAllSysRole(){
	    List<SysRoleDO> data=service.findAllSysRole();
	    return JsonResult.getSuccessJR(data);
	}
	
	@RequestMapping("/findMenuByRoleId")
	public JsonResult<List<Integer>> findMenuByRoleId(Integer roleId){
	    List<Integer> data=service.findMenuByRoleId(roleId);
	    return JsonResult.getSuccessJR(data);
	}

	@PostMapping("/modifySysRole")
	public JsonResult<Void> modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds){
	    service.modifySysRole(sysRoleDO, menuIds);
	    return JsonResult.getSuccessJR();
	}
	
	@PostMapping("/saveSysRole")
	public JsonResult<Void> saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds){
		System.err.println("menuIds="+menuIds);
		for(Integer menuId:menuIds) {
			System.err.println("id="+menuId);
		}
		service.saveSysRole(sysRoleDO,menuIds);
		return JsonResult.getSuccessJR();
	}
	
	@PostMapping("/removeSysRole")
	public JsonResult<Void> removeSysRole(Integer roleId){
	    service.removeSysRole(roleId);
	    // return new JsonResult<Void>(STATE_SUCCESS,MSG_SUCCESS);
	    return JsonResult.getSuccessJR();
	}

	@RequestMapping("/findSysRole")
	public JsonResult<PageObjectVO<SysRoleDO>> findSysRole(String name, Integer pageCurrent){
		PageObjectVO<SysRoleDO> data=service.findSysRole(name, pageCurrent);
		return JsonResult.getSuccessJR(data);
	}
	
}
