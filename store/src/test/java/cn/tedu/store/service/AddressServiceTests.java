package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.service.ex.ServiceException;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午12:20:26
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {

	@Autowired
	private AddressService service;

	@Test
	public void addnew() {
		try {
			Integer uid = 2;
			String username = "路飞";
			Address address = new Address();
			address.setName("娜美");
			service.addnew(uid, username, address);
			System.err.println("ok.");
			System.err.println(address);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getByUid() {
		try {
			Integer uid = 21;
			List<Address> list = service.getByUid(uid);
			for (Address address : list) {
				System.err.println(address);
			}
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void updateDefaultByAid() {
		try {
			Integer aid = 20;
			Integer uid = 21;
			String username = "地址管理员";
			service.setDefault(aid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void delete() {
		try {
			Integer aid = 133;
			Integer uid = 21;
			String username = "地址管理员";
			service.delete(aid, uid, username);
			System.err.println("ok");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
