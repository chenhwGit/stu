package cn.tedu.db.sys.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysRoleDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleServiceTests {
	
	@Autowired
	ISysRoleService service;
	
	@Test
	public void findAllSysRole() {
	    List<SysRoleDO> list=service.findAllSysRole();
	    for(SysRoleDO item:list) {
	        System.err.println(item);
	    }
	}

	@Test
	public void findRoleCount() {
	    Integer[] roleIds= {45,46,47,48};
	    Integer count=service.findRoleCount(null);
	    System.err.println("count="+count);
	}
	
	@Test
	public void modifySysRole() {
	    SysRoleDO sysRoleDO=new SysRoleDO(null, null, "admin", "admin", 
	            55, "testabc", "testabc");
	    Integer[] menuIds= {8,24,25};
	    service.modifySysRole(sysRoleDO, menuIds);
	}
	
	@Test
	public void findMenuByRoleId() {
	    List<Integer> menuIds=service.findMenuByRoleId(59);
	    for(Integer menuId:menuIds) {
	        System.err.println("menuId="+menuId);
	    }
	}
	
	@Test
	public void saveSysRole() {
		SysRoleDO sysRoleDO=new SysRoleDO(null, null, 
				"admin", "admin", null, "测试角色4", "测试note4");
		Integer[] menuIds= {8,24,25};
		service.saveSysRole(sysRoleDO, menuIds);
	}
	
	@Test
	public void removeSysRole() {
	    service.removeSysRole(45);
	}
	
	@Test
	public void findSysRole() {
		PageObjectVO<SysRoleDO> vo=service.findSysRole("系统asddf", 1);
		System.err.println(vo);
	}

}



