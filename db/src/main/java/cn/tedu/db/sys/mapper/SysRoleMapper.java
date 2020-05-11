package cn.tedu.db.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.db.sys.pojo.SysRoleDO;

/**
 * 角色模块的持久层接口
 */
public interface SysRoleMapper {
	
	/**
	 * 基于角色id查询所有的菜单id
	 * @param roleIds 角色id数组
	 * @return 菜单id的集合
	 */
	List<Integer> listMenuIdByRoleId(@Param("roleIds")Integer[] roleIds);
	
	/**
	 * 列出所有角色的id和name 
	 * @return 角色信息的集合
	 */
	List<SysRoleDO> listAllSysRole();

	/**
	 * 基于角色id查询角色数据数量
	 * @param roleIds 角色id数组
	 * @return 实际存在的角色数据数量
	 */
	Integer getRoleCount(@Param("roleIds")Integer[] roleIds);
	
	/**
	 * 基于角色id查询关联的菜单id
	 * @param roleId 角色id
	 * @return 菜单id的集合
	 */
	List<Integer> getMenuByRoleId(Integer roleId);

	/**
	 * 更新角色数据
	 * @param sysRoleDO 新的角色数据
	 * @return 更新成功的行数
	 */
	Integer updateSysRole(SysRoleDO sysRoleDO);
	
	/**
	 * 添加角色记录
	 * @param sysRoleDO 新的角色记录
	 * @return 添加成功的数据条数
	 */
	Integer insertSysRole(SysRoleDO sysRoleDO);

	/**
	 * 添加角色菜单关联记录
	 * @param roleId 角色id
	 * @param menuIds 菜单id的数组
	 * @return 添加成功的数据条数
	 */
	Integer insertRoleMenus(@Param("roleId")Integer roleId, 
							@Param("menuIds")Integer[] menuIds);
	
	/**
	 * 基于角色id删除角色记录
	 * @param roleId
	 * @return
	 */
	Integer deleteSysRole(Integer roleId);

	/**
	 * 基于角色id删除角色菜单关联记录
	 * @param roleId
	 * @return
	 */
	Integer deleteRoleMenu(Integer roleId);

	/**
	 * 基于角色id删除用户角色关联记录
	 * @param roleId
	 * @return
	 */
	Integer deleteUserRole(Integer roleId);

	/**
	 * 基于角色id查询角色菜单关联记录
	 * @param roleId
	 * @return
	 */
	Integer getRoleMenuCount(Integer roleId);

	/**
	 * 基于角色id查询用户角色关联记录
	 * @param roleId
	 * @return
	 */
	Integer getUserRoleCount(Integer roleId);
	
	/**
	 * 基于角色名查询总数据条数
	 * @param name 角色名
	 * @return 总数据条数
	 */
	Integer getRowCount(@Param("name") String name);

	/**
	 * 基于角色名分页查询角色记录
	 * @param recordIndex 跳过的数据条数
	 * @param pageSize 查询的数据条数
	 * @param name 角色名
	 * @return 当前页的角色记录
	 */
	List<SysRoleDO> getPageRecord(@Param("recordIndex")Integer recordIndex,
									@Param("pageSize")Integer pageSize, 
									@Param("name") String name);

}
