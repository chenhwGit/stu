package cn.tedu.db.sys.service;

/**
* @author 作者：chen
* @email 邮箱：727424623@qq.com
* @version v.1.0 创建时间：下午3:21:16
* @description 描述：
*/

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysUserDO;
import cn.tedu.db.sys.service.ex.EmptyArgumentException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.InsertException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;
import cn.tedu.db.sys.service.ex.UsernameExistsException;

public interface ISysUserService {

	/**
	 * 保存用户信息
	 * 
	 * @param sysUserDO 用户信息
	 * @param roleIds   关联的角色id的数组
	 * @throws EmptyArgumentException
	 * @throws RecordNotFoundException
	 * @throws UsernameExistsException
	 * @throws InsertException
	 */
	void saveSysUser(SysUserDO sysUserDO, Integer[] roleIds)
			throws EmptyArgumentException, RecordNotFoundException, UsernameExistsException, InsertException;

	/**
	 * 基于用户名分页查询用户信息
	 * 
	 * @param username    用户名
	 * @param pageCurrent 当前页码
	 * @return 当前数据页
	 * @throws IllegalPageNumberException 对于传入的currentPage为null或者小于1的情况
	 * @throws RecordNotFoundException    对于查询到的数据总条数为0的情况
	 */
	PageObjectVO<SysUserDO> findSysUser(String username, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException;
}
