package cn.tedu.db.sys.service;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysUserDO;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UsernameExistsException;

public interface ISysUserService {
	
	/**
	 * 保存用户信息
	 * @param sysUserDO 用户信息
	 * @param roleIds 关联的角色id的数组
	 * @throws EmptyArgumentException
	 * @throws RecordNotFoundException
	 * @throws EmptyIdException
	 * @throws UsernameExistsException
	 * @throws InsertException
	 */
	void saveSysUser(SysUserDO sysUserDO, Integer[] roleIds)
	        throws EmptyArgumentException, RecordNotFoundException,
	        EmptyIdException, UsernameExistsException, InsertException;

	
	/**
	* 基于用户名分页查询用户信息
	 * @param username 用户名
	 * @param pageCurrent 当前页码
	 * @return 当前页数据
	 * @throws IllegalPageNumberException
	 * @throws RecordNotFoundException
	 */
	PageObjectVO<SysUserDO> findSysUser(
			String username, Integer pageCurrent) 
					throws IllegalPageNumberException, RecordNotFoundException;

}
