package cn.tedu.db.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysUserDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceTests {

	@Autowired
	ISysUserService service;

	@Test
	public void saveSysUser() {
		SysUserDO sysUserDO = new SysUserDO(null, null, "admin", "admin", null, "abcdfdsdf", "123456", "aaaaaa",
				"a@tedu.cn", "13322223333", 1, 1, null);
		Integer[] roleIds = { 45, 57, 58 };
		service.saveSysUser(sysUserDO, roleIds);
	}

	@Test
	public void findSysUser() {
		PageObjectVO<SysUserDO> vo = service.findSysUser("user", 1);
		System.err.println(vo);
	}

}
