package cn.tedu.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.tedu.db.common.aop.SysLogAnnotation;
import cn.tedu.db.common.util.UserUtils;
import cn.tedu.db.sys.mapper.SysMenuMapper;
import cn.tedu.db.sys.pojo.MenuNodeVO;
import cn.tedu.db.sys.pojo.SysMenuDO;
import cn.tedu.db.sys.service.ISysMenuService;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.HasSubMenuException;
import cn.tedu.db.sys.service.ex.IllegalOperationException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.ParentNodeNotFoundException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UpdateException;

@Service
public class SysMenuServiceImpl implements ISysMenuService {

	@Autowired
	SysMenuMapper mapper;

	@SysLogAnnotation(operation = "查询菜单节点")
	public List<MenuNodeVO> findMenuNode() throws RecordNotFoundException {
		// 调用持久层方法，查询菜单节点信息
		List<MenuNodeVO> list = mapper.listMenuNode();
		// 判断返回值是否为null或者长度为0
		if (list == null || list.size() == 0) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询菜单节点异常！未查询到相关记录！");
		}
		// 返回查询到的集合
		return list;
	}

	@SysLogAnnotation(operation = "添加菜单")
	@Transactional
	public void saveSysMenu(SysMenuDO sysMenuDO)
			throws EmptyArgumentException, ParentNodeNotFoundException, InsertException {
		// 判断sysMenuDO是否为null或者sysMenuDO.name是否为空
		if (sysMenuDO == null || StringUtils.isEmpty(sysMenuDO.getName())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("添加菜单异常！新菜单记录为空！");
		}

		// 调用持久层方法，根据sysMenuDO.parentId查询菜单记录
		SysMenuDO parentMenu = mapper.getSysMenu(sysMenuDO.getParentId());
		// 判断查询结果是否为null
		if (parentMenu == null) {
			// 是：ParentNodeNotFoundException！
			throw new ParentNodeNotFoundException("添加菜单异常！父菜单不存在！");
		}

		// 调用持久层方法，执行插入操作
		Integer row = mapper.insertSysMenu(sysMenuDO);
		// 判断返回值是否为0
		if (row == 0) {
			// 是：InsertException
			throw new InsertException("添加菜单异常！菜单添加失败！");
		}
	}

	@SysLogAnnotation(operation = "删除菜单")
	@Transactional(propagation = Propagation.REQUIRED)
	public void removeSysMenu(Integer id) throws EmptyIdException, HasSubMenuException, DeleteException {
		// 判断id是否为null或者小于1
		if (id == null || id < 1) {
			// 是：EmptyIdException
			throw new EmptyIdException("删除菜单异常！菜单id为空！");
		}

		// 调用持久层方法，查询子菜单数量
		Integer subMenuCount = mapper.getSubMenuCount(id);
		// 判断返回值是否不为0
		if (subMenuCount != 0) {
			// 是：HasSubMenuException
			throw new HasSubMenuException("删除菜单异常！请先删除其子菜单项！");
		}

		// 调用持久层方法，删除菜单项
		Integer row1 = mapper.deleteSysMenu(id);
		// 判断返回值是否为0
		if (row1 == 0) {
			// 是：DeleteException
			throw new DeleteException("删除菜单异常！删除菜单记录失败！");
		}

		// 调用持久层方法，查询角色菜单表中关联记录的条数
		Integer roleMenuCount = mapper.getRoleMenuCount(id);
		// 判断返回值是否不为0
		if (roleMenuCount != 0) {// 是：
			// 调用持久层方法，删除角色菜单关联记录
			Integer row2 = mapper.deleteRoleMenu(id);
			// 判断返回值与查询到的关联记录条数是否不一致
			if (row2 != roleMenuCount) {
				// 是：DeleteException
				throw new DeleteException("删除菜单异常！关联数据删除异常！");
			}
		}
	}

	@Override
	@SysLogAnnotation(operation = "查询菜单列表")
	public List<SysMenuDO> findSysMenu() throws RecordNotFoundException {
		// 调用持久层方法，查询菜单记录
		List<SysMenuDO> list = mapper.listSysMenu();
		// 判断返回值是否为null或者长度为0
		if (list == null || list.size() == 0) {
			// 是：抛出RecordNotFoundException
			throw new RecordNotFoundException("查询菜单异常！未查询到相关记录！");
		}
		return list;
	}

	@Override
	@SysLogAnnotation(operation = "查询菜单")
	public SysMenuDO findSysMenuById(Integer id) throws EmptyIdException, RecordNotFoundException {
		// 判断id是否为null或者小于1
		if (id == null || id < 1) {
			// 是：EmptyIdException
			throw new EmptyIdException("查询菜单记录异常！id为空！");
		}
		// 调用持久层方法，查询菜单记录
		SysMenuDO sysMenuDO = mapper.getSysMenu(id);
		// 判断返回值是否为null
		if (sysMenuDO == null) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询菜单异常！未找到队友记录！");
		}
		// 返回查询结果
		return sysMenuDO;
	}

	@Override
	@SysLogAnnotation(operation = "更新菜单")
	@Transactional
	public void modifySysMenu(SysMenuDO sysMenuDO) throws EmptyIdException, EmptyArgumentException,
			ParentNodeNotFoundException, IllegalOperationException, UpdateException {
		// 判断sysMenuDO是否为null
		if (sysMenuDO == null) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("更新菜单异常！菜单数据为空");
		}
		// 判断sysMenuDO.id是否为null或者小于1
		if (sysMenuDO.getId() == null || sysMenuDO.getId() < 1) {
			// 是：EmptyIdException
			throw new EmptyIdException("更新菜单异常！菜单id为空！");
		}
		// 判断sysMenuDO.name是否为null或者为空字符
		if (sysMenuDO.getName() == null || StringUtils.isEmpty(sysMenuDO.getName())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("更新菜单异常！菜单名称为空！");
		}
		// 其他必填字段也已经进行验证

		// 判断sysMenuDO.id和sysMenuDO.parentId是否一致
		if (sysMenuDO.getId().equals(sysMenuDO.getParentId())) {
			// 是：IllegalOperationException
			throw new IllegalOperationException("更新菜单异常！不能讲当前菜单设置为自己的父菜单！");
		}

		// 调用持久层方法，查询parentId对应的记录
		SysMenuDO parentMenu = mapper.getSysMenu(sysMenuDO.getId());
		// 判断记录是否为null
		if (parentMenu == null) {
			// 是：ParentNodeNotFoundException
			throw new ParentNodeNotFoundException("更新菜单异常！未查询到父菜单！");
		}
		// 设置modifiedUser
		sysMenuDO.setModifiedUser(UserUtils.getUsername());
		;
		// 调用持久层方法，执行更新操作
		Integer row = mapper.updateSysMenu(sysMenuDO);
		// 判断返回值是否为0
		if (row == 0) {
			// 是：UpdateException
			throw new UpdateException("更新菜单异常！菜单更新失败！");
		}
	}

	@Override
	@Transactional
	@SysLogAnnotation(operation = "查询菜单数量")
	public Integer findMenuCount(Integer[] menuIds) throws EmptyIdException {
		if (menuIds == null || menuIds.length == 0) {
			throw new EmptyIdException("查询菜单记录异常！菜单id为空！");
		}
		Integer count = mapper.getMenuCount(menuIds);
		return count;
	}
}
