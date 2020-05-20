package cn.tedu.db.sys.service;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysRoleDO;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UpdateException;

/**
 * 角色模块的业务层父接口
 */
public interface ISysRoleService {
	
	/**
	 * 查询所有角色id和name
	 * @return 角色信息的集合
	 * @throws RecordNotFoundException
	 */
	@RequiresPermissions("sys:role:view")
	List<SysRoleDO> findAllSysRole() 
	        throws RecordNotFoundException;

	/**
	 * 基于角色id数组查询对应角色数据条数
	 * @param roleIds 角色id的数组
	 * @return 实际存在的数据条数
	 * @throws EmptyIdException
	 */
	@RequiresPermissions("sys:role:view")
	Integer findRoleCount(Integer[] roleIds)
	        throws EmptyIdException;
	
	/**
	 * 基于角色id查询关联的菜单id
	 * @param roleId 角色id
	 * @return 菜单id的集合
	 * @throws EmptyIdException
	 * @throws RecordNotFoundException
	 */
	@RequiresPermissions("sys:role:view")
	List<Integer> findMenuByRoleId(Integer roleId) 
	        throws EmptyIdException, RecordNotFoundException;
	
	/**
	 * 更新角色记录及角色菜单关联记录
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds 关联的菜单id
	 * @throws EmptyIdException
	 * @throws EmptyArgumentException
	 * @throws RecordNotFoundException
	 * @throws UpdateException
	 * @throws DeleteException
	 * @throws InsertException
	 */
	@RequiresPermissions("sys:role:update")
	void modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds) 
	        throws EmptyIdException, EmptyArgumentException, RecordNotFoundException, 
	        UpdateException, DeleteException, InsertException;
	
	/**
	 * 添加角色记录 
	 * 和角色菜单表中关联记录
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds 关联的菜单记录id的数组
	 * @throws EmptyArgumentException
	 * @throws EmptyIdException
	 * @throws RecordNotFoundException
	 * @throws InsertException
	 */
	@RequiresPermissions("sys:role:add")
	void saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds)
			throws EmptyArgumentException, EmptyIdException, 
				 RecordNotFoundException, InsertException;
	
	/**
	 * 基于角色id删除角色记录
	 * 同时删除角色菜单关联记录 和 
	 * 用户角色关联记录
	 * 
	 * @param roleId 角色id
	 * @throws EmptyIdException
	 * @throws DeleteException
	 */
	@RequiresPermissions("sys:role:delete")
	void removeSysRole(Integer roleId) 
	        throws EmptyIdException, DeleteException;
	
	/**
	 * 基于角色名称分页查询角色记录
	 * @param name 角色名称
	 * @param pageCurrent 当前页码
	 * @return 当前页记录
	 * @throws IllegalPageNumberException
	 * @throws RecordNotFoundException
	 */
	@RequiresPermissions("sys:role:view")
	PageObjectVO<SysRoleDO> findSysRole(String name, Integer pageCurrent)
		throws IllegalPageNumberException, RecordNotFoundException;

}
