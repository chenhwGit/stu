package cn.tedu.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;
import cn.tedu.store.service.ex.ServiceException;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午9:11:08
 * @description 描述：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService service;

	@Test
	public void reg() {
		try {
			User user = new User();
			user.setUsername("lucy");
			user.setPassword("123456");
			user.setGender(0);
			user.setPhone("138001380056");
			user.setEmail("lucy@.com");
			user.setAvatar("avatar");
			service.reg(user);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
		}
	}

	@Test
	public void login() {
		try {
			String username = "lucy";
			String password = "abc123";
			User user = service.login(username, password);
			System.err.println("ok.");
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changePassword() {
		try {
			Integer uid = 19;
			String username = "Bob";
			String oldPassword = "123456";
			String newPassword = "abc123";
			service.changePassword(uid, username, oldPassword, newPassword);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getInfo() {
		try {
			Integer uid = 5;
			User result = service.getInfo(uid);
			System.err.println("ok.");
			System.err.println(result);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changeInfo() {
		try {
			Integer uid = 19;
			String username = "超级管理员";
			User user = new User();
			user.setPhone("138001380001");
			user.setEmail("138001380001@163.com");
			user.setGender(1);
			service.changeInfo(uid, username, user);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void changeAvatar() {
		try {
			Integer uid = 19;
			String username = "lucy";
			String avatar = "头像";
			service.changeAvatar(uid, username, avatar);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

}
