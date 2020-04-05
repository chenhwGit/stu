package cn.tedu.store;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.store.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreApplicationTests {

	@Test
	public void contextLoads() {
		User user = new User();
	}

	@Test
	public void uuid() {
		for (int i = 0; i < 20; i++) {
			String uuid = UUID.randomUUID().toString();
			System.err.println(uuid);
		}
	}

	@Test
	public void md5() {
		String password = "1234";
		String salt = UUID.randomUUID().toString();
		String result = DigestUtils.md5Hex(salt + password + salt);
		System.err.println(result);
	}

}
