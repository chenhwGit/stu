package cn.tedu.db.common.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import cn.tedu.db.sys.pojo.SysUserDO;

public class UserUtils {
	
	/**
	 * 获取当前用户的用户名
	 * 如果当前用户未登录，返回visitor
	 * @return
	 */
	public static String getUsername() {
		// TODO 通过Shiro的API来实现
		String username="visitor";
		// 通过Shiro的API获取当前用户对应的Subject
		Subject subject=SecurityUtils.getSubject();
		// 获取用户身份
		Object principal=subject.getPrincipal();
		if(principal!=null) {// 有登录信息
			username=((SysUserDO)principal).getUsername();
		}
		return username;
	}
}
