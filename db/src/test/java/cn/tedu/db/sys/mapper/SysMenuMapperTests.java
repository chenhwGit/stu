package cn.tedu.db.sys.mapper;

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
public class SysMenuMapperTests {

	@Autowired
	SysMenuMapper mapper;

	@Test
	public void listMenuNode() {
		List<MenuNodeVO> list = mapper.listMenuNode();
		for (MenuNodeVO vo : list) {
			System.err.println(vo);
		}
	}

	@Test
	public void getSysMenu() {
		SysMenuDO menu = mapper.getSysMenu(null);
		System.err.println(menu);
	}

	@Test
	public void insertSysMenu() {
		SysMenuDO sysMenuDO = new SysMenuDO(null, null, "Tester", "Tester", null, "测试菜单1", "testurl", 1, 12, "testNote",
				8, "user:test");
		Integer row = mapper.insertSysMenu(sysMenuDO);
		System.err.println("row=" + row);
	}

	@Test
	public void getSubMenuCount() {
		Integer count = mapper.getSubMenuCount(130);
		System.err.println("count=" + count);
	}

	@Test
	public void deleteSysMenu() {
		Integer row = mapper.deleteSysMenu(130);
		System.err.println("row=" + row);
	}

	@Test
	public void getRoleMenuCount() {
		Integer count = mapper.getRoleMenuCount(48);
		System.err.println("count=" + count);
	}

	@Test
	public void deleteRoleMenu() {
		Integer row = mapper.deleteRoleMenu(48);
		System.err.println("row=" + row);
	}

	@Test
	public void updateSysMenu() {
		SysMenuDO sysMenuDO = new SysMenuDO(null, null, "Tester", "Tester", 143, "测试菜单1", "tersturl2", 1, 12,
				"testNote", 24, "user:test");
		Integer row = mapper.updateSysMenu(sysMenuDO);
		System.err.println("row = " + row);
	}

	@Test
	public void listSysMenu() {
		List<SysMenuDO> list = mapper.listSysMenu();
		for (SysMenuDO menu : list) {
			System.err.println(menu);
		}
	}

	@Test
	public void getSysMenuById() {
		SysMenuDO sysMenuDO = mapper.getSysMenuById(24);
		System.err.println(sysMenuDO);
	}

	@Test
	public void getMenuCount() {
		Integer[] menuIds = { 8, 24,25,26};
		Integer count = mapper.getMenuCount(menuIds);
		System.err.println("count=" + count);
	}

}
