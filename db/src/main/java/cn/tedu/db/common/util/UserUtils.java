package cn.tedu.db.common.util;

public class UserUtils {
	
	/**
	 * 获取当前用户的用户名
	 * 如果当前用户未登录，返回visitor
	 * @return
	 */
	public static String getUsername() {
		// TODO 通过Shiro的API来实现
		String username="visitor";
		return username;
	}
}
