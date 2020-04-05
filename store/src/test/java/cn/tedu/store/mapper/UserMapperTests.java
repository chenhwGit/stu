package cn.tedu.store.mapper;

import cn.tedu.store.entity.User;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午3:40:04
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	@Autowired
	private UserMapper mapper;

	@Test
	public void insert() {
		User user = new User();
		user.setUsername("root");
		user.setPassword("1234");
		user.setSalt("salt");
		user.setGender(0);
		user.setPhone("13800138002");
		user.setEmail("project163@.com");
		user.setAvatar("avatar");
		user.setIsDelete(0);
		user.setCreatedUser("系统管理员");
		user.setCreatedTime(new Date());
		user.setModifiedUser("超级管理员");
		user.setModifiedTime(new Date());
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
		System.err.println(user);
	}

	@Test
	public void updateInfoByUid() {
		User user = new User();
		user.setUid(1);
		user.setPhone("13000138000");
		user.setEmail("1300138000@163.com");
		user.setGender(0);
		Integer rows = mapper.updateInfoByUid(user);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updatePasswordByUid() {
		Integer uid = 2;
		String password = "abc123";
		String modifiedUser = mapper.findByUid(uid).getUsername();
		Date modifiedTime = new Date();
		Integer rows = mapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateAvatarByUid() {
		Integer uid = 19;
		String avatar = "666";
		String modifiedUser = mapper.findByUid(uid).getUsername();
		Date modifiedTime = new Date();
		Integer rows = mapper.updateAvatarByUid(uid, avatar, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}

	@Test
	public void findByUsername() {
		String username = "project";
		User user = mapper.findByUsername(username);
		System.err.println(user);
	}

	@Test
	public void findByUid() {
		Integer uid = 2;
		User user = mapper.findByUid(uid);
		System.err.println(user);
	}

}
