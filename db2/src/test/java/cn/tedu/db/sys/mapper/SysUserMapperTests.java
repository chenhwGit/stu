package cn.tedu.db.sys.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.sys.pojo.SysLogDO;
import cn.tedu.db.sys.pojo.SysUserDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTests {
	
	@Autowired
	SysUserMapper mapper;
	
	@Test
	public void listRoleIdByUserId() {
	    List<Integer> list=mapper.listRoleIdByUserId(24);
	    for(Integer roleId:list) {
	        System.err.println("roleId="+roleId);
	    }
	}
	
	@Test
	public void getUserByUsername() {
	    SysUserDO user=mapper.getUserByUsername("admin");
	    System.err.println(user);
	}

	@Test
	public void insertSysUser() {
	    SysUserDO sysUserDO=new SysUserDO(null, null, 
	            "admin", "admin", null, "abc", "123456", "aaaaaa", 
	            "a@tedu.cn", "13322223333", 1, 1, null);
	    Integer row=mapper.insertSysUser(sysUserDO);
	    System.err.println("row="+row);
	}

	@Test
	public void insertUserRoles() {
	    Integer userId=16;
	    Integer[] roleIds= {48,49,50};
	    Integer row=mapper.insertUserRoles(userId, roleIds);
	    System.err.println("row="+row);
	}

	
	@Test
	public void listSysUser() {
		List<SysUserDO> list=mapper.listSysUser("user",0, 3);
		for(SysUserDO sysUserDO:list) {
			System.err.println(sysUserDO);
		}
	}
	
	@Test
	public void getRowCount() {
		Integer count=mapper.getRowCount(null);
		System.err.println("count="+count);
	}
}
