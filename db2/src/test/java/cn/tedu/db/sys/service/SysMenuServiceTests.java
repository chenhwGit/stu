package cn.tedu.db.sys.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.sys.pojo.MenuNodeVO;
import cn.tedu.db.sys.pojo.SysMenuDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuServiceTests {
	
	@Autowired
	ISysMenuService service;
	
	@Test
	public void findMenuCount() {
		Integer[] menuIds= {8,24,25};
		Integer count=service.findMenuCount(menuIds);
		System.err.println("count="+count);
	}
	
	@Test
	public void findSysMenuById() {
		Integer id=199;
		SysMenuDO sysMenuDO=service.findSysMenuById(id);
		System.err.println(sysMenuDO);
	}

	@Test
	public void modifySysMenu() {
		SysMenuDO sysMenuDO=new SysMenuDO(null, null, 
				"Tester", "Tester", 199, "testName111", "testurl", 1, 12, "testNote", 8, "user:test");
		service.modifySysMenu(sysMenuDO);
	}
	
	@Test
	public void findMenuNode() {
		List<MenuNodeVO> list=service.findMenuNode();
		for(MenuNodeVO vo:list) {
			System.err.println(vo);
		}
	}
	
	@Test
	public void saveSysMenu() {
		SysMenuDO sysMenuDO=new SysMenuDO(null, null, 
				"Tester", "Tester", null, "测试菜单3", "testurl", 1, 12, "testNote", 8, "user:test");
		service.saveSysMenu(sysMenuDO);
	}
	
	@Test
	public void removeSysMenu() {
		Integer id=48;
		service.removeSysMenu(id);
	}
	
	
	@Test
	public void findSysMenu() {
		List<SysMenuDO> list=service.findSysMenu();
		for(SysMenuDO menu:list) {
			System.err.println(menu);
		}
	}
}



