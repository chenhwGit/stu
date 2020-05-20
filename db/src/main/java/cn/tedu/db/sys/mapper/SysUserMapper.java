package cn.tedu.db.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.db.sys.pojo.SysUserDO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午2:46:30
 * @description 描述：
 */
public interface SysUserMapper {

	/**
	 * 插入用户信息
	 * 
	 * @param sysUserDO 用户信息
	 * @return 添加成功的数据条数
	 */
	Integer insertSysUser(SysUserDO sysUserDO);

	/**
	 * 添加用户角色关联信息
	 * 
	 * @param userId  用户id
	 * @param roleIds 角色id数组
	 * @return 添加成功的数据条数
	 */
	Integer insertUserRoles(@Param("userId") Integer userId, @Param("roleIds") Integer[] roleIds);

	/**
	 * 基于用户分页查询用户信息
	 * 
	 * @param username    用户名
	 * @param recordIndex 跳过的数据条数
	 * @param pageSize    查询的数据条数
	 * @return 当前页记录
	 */
	List<SysUserDO> listSysUser(@Param("username") String username, @Param("recordIndex") Integer recordIndex,
			@Param("pageSize") Integer pageSize);

	/**
	 * 基于用户名查询总记录条数
	 * 
	 * @param username 用户名
	 * @return 对应的总记录条数
	 */
	Integer getRowCount(@Param("username") String username);

	/**
	 * 基于用户名查询用户信息
	 * 
	 * @param username 用户名
	 * @return 用户信息
	 */
	SysUserDO getUserByUsername(String username);
}
