package cn.tedu.db.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.db.common.pojo.JsonResult;
import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysLogDO;
import cn.tedu.db.sys.service.ISysLogService;

@RestController
@RequestMapping("/log")
public class SysLogController {
	
	@Autowired
	ISysLogService service;
	
	@PostMapping("/delete")
	public JsonResult<Void> removeSysLog(Integer[] ids){
		service.removeSysLog(ids);
		return JsonResult.getSuccessJR();
	}

	@RequestMapping("/findSysLog")
	public JsonResult<PageObjectVO<SysLogDO>> findSysLog(String username, Integer pageCurrent){
		PageObjectVO<SysLogDO> data=service.findSysLog(username, pageCurrent);
		// return new JsonResult<PageObjectVO<SysLogDO>>(20,"OK",data);
		return JsonResult.getSuccessJR(data);
	}

}
