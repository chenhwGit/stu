package cn.tedu.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.tedu.db.common.aop.SysLogAnnotation;
import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.common.util.UserUtils;
import cn.tedu.db.sys.mapper.SysRoleMapper;
import cn.tedu.db.sys.pojo.SysRoleDO;
import cn.tedu.db.sys.service.ISysMenuService;
import cn.tedu.db.sys.service.ISysRoleService;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UpdateException;

@Service
public class SysRoleServiceImpl implements ISysRoleService{

	@Autowired
	SysRoleMapper mapper;

	Integer pageSize=2;
	
	@Autowired
	ISysMenuService menuService;
	
	public List<SysRoleDO> findAllSysRole() 
	        throws RecordNotFoundException{
	    List<SysRoleDO> list=mapper.listAllSysRole();
	    if(list==null || list.size()==0){
	        throw new RecordNotFoundException("查询角色信息异常！未查询到相关记录！");
	    }
	    return list;
	}

	public Integer findRoleCount(Integer[] roleIds)
	        throws EmptyIdException{
	    if(roleIds==null ||roleIds.length==0){
	        throw new EmptyIdException("查询角色记录条数异常！角色id为空");
	    }
	    Integer count=mapper.getRoleCount(roleIds);
	    return count;
	}
	
	@Transactional
	@SysLogAnnotation(operation = "修改角色")
	public void modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds) throws EmptyIdException, EmptyArgumentException, RecordNotFoundException, UpdateException,
	        DeleteException, InsertException{
	    // 判断sysRoleDO是否为null或sysRoleDO.name是否为空
	    if(sysRoleDO==null || StringUtils.isEmpty(sysRoleDO.getName())) {
	        // 是：EmptyArgumentException
	        throw new EmptyArgumentException("更新角色记录异常！角色记录为空");
	    }

	    // 判断sysRoleDO.id是否为null或小于1
	    if(sysRoleDO.getId()==null || sysRoleDO.getId()<1) {
	        // 是：EmptyIdException
	        throw new EmptyIdException("更新角色记录异常！角色id为空");
	    }
	    
	    // 添加modifiedUser
	    sysRoleDO.setModifiedUser(UserUtils.getUsername());
	    
	    // 调用持久层方法，更新角色记录
	    Integer row1=mapper.updateSysRole(sysRoleDO);
	    // 判断返回值是否为0
	    if(row1==0) {
	        // 是：UpdateException
	        throw new UpdateException("更新角色记录异常！更新失败");
	    }

	    // 调用menuService的方法，查询menuIds对应的数据条数
	    Integer menuCount=menuService.findMenuCount(menuIds);
	    // 判断查询结果与menuIds数组长度是否不一致
	    if(menuCount!=menuIds.length) {
	        // 是：RecordNotFoundException
	        throw new RecordNotFoundException("更新角色记录异常！关联的菜单项可能不存在");
	    }

	    // 调用持久层方法，查询旧的角色菜单关联记录的条数
	    Integer roleMenuCount=mapper.getRoleMenuCount(sysRoleDO.getId());
	    // 调用持久层方法，删除旧的角色菜单关联记录
	    Integer row2=mapper.deleteRoleMenu(sysRoleDO.getId());
	    // 判断返回值与查询到的关联记录条数是否不一致
	    if(roleMenuCount!=row2) {
	        // 是：DeleteException
	        throw new DeleteException("更新角色记录异常！删除旧关联记录异常");
	    }

	    // 调用持久层方法，添加新的角色菜单关联记录
	    Integer row3=mapper.insertRoleMenus(sysRoleDO.getId(), menuIds);
	    // 判断返回值与menuIds的长度是否不一致
	    if(row3!=menuIds.length) {
	        // 是：InsertException
	        throw new InsertException("更新角色记录异常！添加新关联记录异常");
	    }
	}
	
	@SysLogAnnotation(operation = "查询关联菜单id")
	public List<Integer> findMenuByRoleId(Integer roleId) 
	        throws EmptyIdException, RecordNotFoundException{
	    // 判断roleId是否为null或者小于1
	    if(roleId==null || roleId<1) {
	        // 是：抛出EmptyIdException
	        throw new EmptyIdException("查询关联菜单id异常！角色id为空");
	    }
	    // 调用持久层方法，查询对应的菜单id
	    List<Integer> menuIds=mapper.getMenuByRoleId(roleId);
	    // 判断查询结果是否为null或者长度为0
	    if(menuIds==null || menuIds.size()==0) {
	        // 是：RecordNotFoundException
	        throw new RecordNotFoundException("查询关联菜单id异常！未查询到相关记录！");
	    }
	    // 返回查询结果
	    return menuIds;
	}

	@Transactional
	@SysLogAnnotation(operation = "添加角色")
	public void saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds)
			throws EmptyArgumentException, EmptyIdException, 
				 RecordNotFoundException, InsertException{
		// 判断sysRoleDO是否为null 或者 name是否为空
		if(sysRoleDO==null || StringUtils.isEmpty(sysRoleDO.getName())) {
			// 是：EmptyArgumentException
			throw new EmptyArgumentException("添加角色异常！角色记录为空");
		}
		
		// 设置createdUser和modifiedUser
		sysRoleDO.setCreatedUser(UserUtils.getUsername());
		sysRoleDO.setModifiedUser(UserUtils.getUsername());

		// 调用持久层方法，添加角色记录
		Integer row1=mapper.insertSysRole(sysRoleDO);
		// 判断返回值是否为0 或 id是否为null
		if(row1==0|| sysRoleDO.getId()==null) {
			// 是：InsertException
			throw new InsertException("添加角色异常！角色添加失败");
		}

		// 调用menuService的方法，查询菜单记录个数
		Integer menuCount=menuService.findMenuCount(menuIds);
		// 判断菜单记录个数是否与menuIds的长度不一致
		if(menuCount!=menuIds.length) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("添加角色异常！关联的菜单可能不存在");
		}

		// 调用持久层方法，添加角色菜单关联记录
		Integer row2=mapper.insertRoleMenus(sysRoleDO.getId(), menuIds);
		// 判断返回值与menuIds的长度是否不一致
		if(row2!=menuIds.length) {
			// 是：InsertException
			throw new InsertException("添加角色异常！角色菜单关联记录添加异常");
		}
	}
	
	@Transactional
	@SysLogAnnotation(operation = "删除角色")
	public void removeSysRole(Integer roleId) 
	        throws EmptyIdException, DeleteException{
	    // 判断roleId是否为null或者小于1
	    if(roleId==null || roleId<1) {
	        // 是：抛出EmptyIdException
	        throw new EmptyIdException("删除角色记录异常！角色id为空");
	    }

	    // 调用持久层方法，删除角色表中的记录
	    int row1=0;
	    try {
	        row1=mapper.deleteSysRole(roleId);
	    }catch(Exception e) {
	        // 是：抛出DeleteException
	        throw new DeleteException("删除角色记录异常！请联系管理员",e);
	    }

	    // 判断返回值是否为0
	    if(row1==0) {
	        // 是：抛出DeleteException
	        throw new DeleteException("删除角色记录异常！请联系管理员");
	    }

	    // 调用持久层方法，查询角色菜单关联记录条数
	    int roleMenuCount=0;
	    try {
	        roleMenuCount=mapper.getRoleMenuCount(roleId);
	    } catch (Exception e) {
	        throw new DeleteException("删除角色记录异常！查询角色菜单关联记录异常",e);
	    }
	    // 判断返回值是否不为0
	    if(roleMenuCount!=0) { // 是：
	        // 调用持久层方法，删除角色菜单关联记录
	        int row2=0;
	        try {
	            row2=mapper.deleteRoleMenu(roleId);
	        } catch (Exception e) {
	            throw new DeleteException("删除角色记录异常！删除角色菜单关联记录异常",e);
	        }
	        // 判断返回值与查询到的关联记录条数是否不一致
	        if(row2!=roleMenuCount) {
	            // 是：抛出DeleteException
	            throw new DeleteException("删除角色记录异常！删除角色菜单关联记录异常");
	        }
	    }

	    // 调用持久层方法，查询用户角色关联记录条数
	    int userRoleCount=0;
	    try {
	        userRoleCount=mapper.getUserRoleCount(roleId);
	    } catch (Exception e) {
	        throw new DeleteException("删除角色记录异常！查询用户角色关联记录异常",e);
	    }
	    // 判断返回值是否不为0
	    if(userRoleCount!=0) {// 是：
	        // 调用持久层方法，删除用户角色关联记录
	        int row3=0;
	        try {
	            row3=mapper.deleteUserRole(roleId);
	        } catch (Exception e) {
	            throw new DeleteException("删除角色记录异常！删除用户角色关联记录异常",e);
	        }
	        // 判断返回值与查询到的关联记录条数是否不一致
	        if(row3!=userRoleCount) {
	            // 是：抛出DeleteException
	            throw new DeleteException("删除角色记录异常！删除用户角色关联记录异常");
	        }
	    }
	}

	@SysLogAnnotation(operation = "查询角色")
	public PageObjectVO<SysRoleDO> findSysRole(String name, Integer pageCurrent)
				throws IllegalPageNumberException, RecordNotFoundException{
		// 判断pageCurrent是否为null或小于1
		if(pageCurrent==null || pageCurrent<1) {
			// 是：IllegalPageNumberException
			throw new IllegalPageNumberException("查询角色异常！当前页码错误");
		}

		// 调用持久层方法，查询总数据条数
		Integer rowCount=mapper.getRowCount(name);
		// 判断返回值是否为0
		if(rowCount==0) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询角色异常！未查询到相关记录");
		}

		// 计算生成recordIndex
		Integer recordIndex=(pageCurrent-1)*pageSize;
		// 调用持久层方法，查询当前页记录
		List<SysRoleDO> pageRecord=mapper.getPageRecord(recordIndex, pageSize, name);
		// 创建PageObjectVO对象
		PageObjectVO<SysRoleDO> vo=new PageObjectVO<SysRoleDO>();
		// 向PageObjectVO对象中填充数据
		vo.setPageCount((rowCount-1)/pageSize+1);
		vo.setPageCurrent(pageCurrent);
		vo.setPageRecord(pageRecord);
		vo.setPageSize(pageSize);
		vo.setRowCount(rowCount);
		// 返回pageObjectVO对象
		return vo;
	}
}
