package cn.tedu.db.sys.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.sys.pojo.SysRoleDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysRoleMapperTests {
	
	@Autowired
	SysRoleMapper mapper;
	
	@Test
	public void listMenuIdByRoleId() {
	    Integer[] roleIds= {56,57};
	    List<Integer> list=mapper.listMenuIdByRoleId(roleIds);
	    for(Integer menuId:list) {
	        System.err.println("menuId="+menuId);
	    }
	}
	
	@Test
	public void listAllSysRole() {
	    List<SysRoleDO> list=mapper.listAllSysRole();
	    for(SysRoleDO sysRoleDO:list) {
	        System.err.println(sysRoleDO);
	    }
	}

	@Test
	public void getRoleCount() {
	    Integer[] roleIds= {48,49,50,51};
	    Integer count=mapper.getRoleCount(roleIds);
	    System.err.println("count="+count);
	}

	
	
	@Test
	public void getMenuByRoleId() {
	    List<Integer> menuIds=mapper.getMenuByRoleId(55);
	    for(Integer menuId:menuIds) {
	        System.err.println("menuId="+menuId);
	    }
	}

	@Test
	public void updateSysRole() {
	    SysRoleDO sysRoleDO=new SysRoleDO(null, null, "admin", "tester", 
	            55, "updateRole", "updateNote");
	    Integer row=mapper.updateSysRole(sysRoleDO);
	    System.err.println("row="+row);
	}
	
	@Test
	public void insertSysRole() {
		SysRoleDO sysRoleDO=new SysRoleDO(null, null, 
				"admin", "admin", null, "测试角色", "测试note");
		Integer row=mapper.insertSysRole(sysRoleDO);
		System.err.println("row="+row);
		System.err.println("id="+sysRoleDO.getId());
	}
	
	@Test
	public void insertRoleMenu() {
		Integer roleId=48;
		Integer[] menuIds= {8,24,25};
		Integer count=mapper.insertRoleMenus(roleId, menuIds);
		System.err.println("count="+count);
	}
	
	@Test
	public void deleteSysRole() {
	    Integer row=mapper.deleteSysRole(47);
	    System.err.println("row="+row);
	}

	@Test
	public void deleteRoleMenu() {
	    Integer row=mapper.deleteRoleMenu(45);
	    System.err.println("row="+row);
	}

	@Test
	public void deleteUserRole() {
	    Integer row=mapper.deleteUserRole(45);
	    System.err.println("row="+row);
	}

	@Test
	public void getRoleMenuCount() {
	    Integer count=mapper.getRoleMenuCount(45);
	    System.err.println("count="+count);
	}

	@Test
	public void getUserRoleCount() {
	    Integer count=mapper.getUserRoleCount(45);
	    System.err.println("count="+count);
	}   
	
	@Test
	public void getRowCount() {
		Integer rowCount=mapper.getRowCount("经理");
		System.err.println("row="+rowCount);
	}
	
	@Test
	public void getPageRecord() {
		List<SysRoleDO> list=mapper.getPageRecord(1, 3, "系统");
		for(SysRoleDO item:list) {
			System.err.println(item);
		}
	}

}
