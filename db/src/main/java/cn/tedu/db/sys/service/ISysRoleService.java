package cn.tedu.db.sys.service;

import java.util.List;

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
	 * 添加角色记录和角色菜单表中关联记录
	 * 
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds   关联的菜单记录id的数组
	 * @throws EmptyArgumentException  针对sysRoleDO为null或者sysRoleDO.name为空的异常
	 * @throws EmptyIdException        针对menuIds为null或者长度为0的异常
	 * @throws RecordNotFoundException 针对查询到的菜单记录与menuIds数组长度不一致的异常
	 * @throws InsertException         针对添加角色菜单关联记录的返回值与menuIds数组长度不一致的异常
	 */
	void saveSysRole(SysRoleDO sysRoleDO, Integer[] menuIds)
			throws EmptyArgumentException, EmptyIdException, RecordNotFoundException, InsertException;

	/**
	 * 基于角色id删除角色记录 同时删除角色菜单关联记录 和 用户角色关联记录
	 * 
	 * @param roleId 角色id
	 * @throws EmptyIdException
	 * @throws DeleteException
	 */
	void removeSysRole(Integer roleId) throws EmptyIdException, DeleteException;

	/**
	 * 更新角色记录及菜单关联记录
	 * 
	 * @param sysRoleDO 新的角色记录
	 * @param menuIds   关联的菜单id
	 * @throws EmptyIdException        针对传入的sysRoleDO.id为空时的异常
	 * @throws EmptyArgumentException  针对传入的sysRoleDO为null，或者sysRoleDO.name为空的异常
	 * @throws RecordNotFoundException 针对使用roleId查询到的菜单id集合为null或者长度为0的异常
	 * @throws UpdateException         针对更新角色操作，返回值为0的异常
	 * @throws DeleteException         针对删除旧的角色菜单关联记录的返回值与查询到的角色菜单关联记录的数据条数不一致的异常
	 * @throws InsertException         针对插入新的角色菜单关联记录的返回值与menuIds数组的长度不一致的
	 */
	void modifySysRole(SysRoleDO sysRoleDO, Integer[] menuIds) throws EmptyIdException, EmptyArgumentException,
			RecordNotFoundException, UpdateException, DeleteException, InsertException;

	/**
	 * 基于角色名称分页查询角色记录
	 * 
	 * @param name        角色名称
	 * @param pageCurrent 当前页码
	 * @return 当前页记录
	 * @throws IllegalPageNumberException 针对pageCurrent为null或者小于1的异常
	 * @throws RecordNotFoundException    针对查询到的rowCount为0的异常
	 */
	PageObjectVO<SysRoleDO> findSysRole(String name, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException;

	/**
	 * 基于角色id查询关联的菜单id
	 * 
	 * @param roleId 角色id
	 * @return 菜单id的集合
	 * @throws EmptyIdException        针对传入的roleId为null或者小于1的异常
	 * @throws RecordNotFoundException 针对使用roleId查询到的菜单id集合为null或者长度为0的异常
	 */
	List<Integer> findMenuByRoleId(Integer roleId) throws EmptyIdException, RecordNotFoundException;

	/**
	 * 查询所有角色id和name
	 * 
	 * @return 角色信息的集合
	 * @throws RecordNotFoundException
	 */
	List<SysRoleDO> findAllSysRole() throws RecordNotFoundException;

	/**
	 * 基于角色id数组查询对应角色数据条数
	 * 
	 * @param roleIds 角色id的数组
	 * @return 实际存在的数据条数
	 * @throws EmptyIdException
	 */
	Integer findRoleCount(Integer[] roleIds) throws EmptyIdException;
}
