package cn.tedu.db.common.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.db.common.pojo.JsonResult;

/**
 * 响应用户对html页面请求的控制器
 */
@Controller
public class PageController {
	
	@RequestMapping("/login_page")
	public String findloginPage(){
	    return "login";
	}
	
	@RequestMapping("/")
	public String getStarterPage(){
		return "starter";
	}
	
	@RequestMapping("/sys/{subPage}")
	public String getSubPage(@PathVariable("subPage")String pageName) {
		// url ->  /sys/log_list  -> pageName->log_list
		// url ->  /sys/menu_list -> pageName->menu_list
		return "sys/"+pageName;
	}
	
	@RequestMapping("/common/page")
	public String getPage(){
		return "common/page";
	}

	@RequestMapping("/echartData")
	@ResponseBody
	public JsonResult<Map<String,Integer[]>> testEChart(){
		Map<String, Integer[]> map=new HashMap<String, Integer[]>();
		// 实际开发中，这部分数据是调用业务层->持久层->数据库去获取
		Integer[] yData1= {5, 20, 36, 10, 10, 20};
		Integer[] yData2= {15, 25, 39, 13, 16, 26};
		map.put("yData1", yData1);
		map.put("yData2", yData2);
		return JsonResult.getSuccessJR(map);
	}
	
}
