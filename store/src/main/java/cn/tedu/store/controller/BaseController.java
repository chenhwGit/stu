package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:49:51
 * @description 描述：
 */
abstract class BaseController {
	/** 响应到客户端的、表示操作成功的状态值 */
	protected static final int OK = 2000;

	/**
	 * 获取当前用户的用户id
	 * 
	 * @param session
	 * @return
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}

	/**
	 * 获取当前用户的用户名
	 * 
	 * @param session
	 * @return
	 */
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}

}
