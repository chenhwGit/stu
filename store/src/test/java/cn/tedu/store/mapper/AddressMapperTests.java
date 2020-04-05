package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.Address;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:46:15
 * @description 描述：
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
	@Autowired
	AddressMapper mapper;

	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(1);
		address.setName("root");
		address.setProvinceName("浙江省");
		address.setProvinceCode("111");
		address.setCityName("杭州市");
		address.setCityCode("222");
		address.setAreaName("萧山区");
		address.setAreaCode("333");
		address.setZip("31006");
		address.setAddress("下沙");
		address.setPhone("1380010001");
		address.setTel("0580-685541");
		address.setTag("abc");
		address.setIsDefault(1);
		Integer rows = mapper.insert(address);
		System.err.println("rows=" + rows);
		System.err.println(address);
	}

	@Test
	public void deleteByAid() {
		Integer aid = 12;
		Integer rows = mapper.deleteByAid(aid);
		System.err.println("rows=" + rows);
	}

	@Test
	public void countByUid() {
		Integer uid = 1;
		Integer rows = mapper.countByUid(uid);
		System.err.println("rows=" + rows);
	}

	@Test
	public void findByUid() {
		Integer uid = 21;
		List<Address> list = mapper.findByUid(uid);
		for (Address address : list) {
			System.err.println(address);
		}
	}

	@Test
	public void findByAid() {
		Integer aid = 24;
		Address address = mapper.findByAid(aid);
		System.err.println(address);
	}

	@Test
	public void updateNonDefaultByUid() {
		Integer uid = 21;
		Integer rows = mapper.updateNonDefaultByUid(uid);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateDefaultByAid() {
		Integer aid = 14;
		String modifiedUser = "地址管理员";
		Integer rows = mapper.updateDefaultByAid(aid, modifiedUser, new Date());
		System.err.println("rows=" + rows);
	}

	@Test
	public void findLastModified() {
		Integer uid = 21;
		Address address = mapper.findLastModified(uid);
		System.err.println(address);
	}

}
