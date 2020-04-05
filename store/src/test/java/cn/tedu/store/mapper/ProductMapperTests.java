package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Product;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:46:15
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTests {
	@Autowired
	ProductMapper mapper;

	@Test
	public void updateNumById() {
		Integer id = 10000001;
		Integer num = 99998;
		String modifiedUser = "库存管理员";
		Integer rows = mapper.updateNumById(id, num, modifiedUser, new Date());
		System.err.println("rows=" + rows);
	}

	@Test
	public void findHotList() {
		List<Product> list = mapper.findHotList();
		for (Product product : list) {
			System.err.println(product);
		}
	}

	@Test
	public void findById() {
		Integer id = 10000001;
		Product product = mapper.findById(id);
		System.err.println(product);

	}

}
