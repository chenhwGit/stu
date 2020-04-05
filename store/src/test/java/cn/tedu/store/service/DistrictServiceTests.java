package cn.tedu.store.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.District;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:46:15
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {
	@Autowired
	DistrictService service;

	@Test
	public void getByParent() {
		String parent = "86";
		List<District> list = service.getByParent(parent);
		System.err.println("count=" + list.size());
		for (District item : list) {
			System.err.println(item);
		}
	}

	@Test
	public void findNameByCode() {
		String code = "110000";
		String name = service.getNameByCode(code);
		System.err.println("name=" + name);

	}

}
