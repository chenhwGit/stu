package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Product;
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
public class ProductServiceTests {

	@Autowired
	private ProductService service;

	@Test
	public void reduceNum() {
		try {
			Integer id = 10000001;
			Integer amount = 99990;
			String username = "仓库管理员";
			service.reduceNum(id, amount, username);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}

	@Test
	public void getHotList() {
		List<Product> list = service.getHotList();
		for (Product product : list) {
			System.err.println(product);
		}
	}

	@Test
	public void getById() {
		try {
			Integer id = 10000001;
			service.getById(id);
			System.err.println("ok.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}
