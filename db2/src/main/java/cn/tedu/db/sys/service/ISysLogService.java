package cn.tedu.db.sys.service;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysLogDO;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;

/**
 * 日志模块的业务层父接口
 */
public interface ISysLogService {
	
	/**
	 * 基于日志id删除日志记录
	 * @param ids 日志id数组
	 * @throws EmptyIdException
	 * @throws DeleteException
	 */
	void removeSysLog(Integer[] ids) 
			throws EmptyIdException, DeleteException;
	
	/**
	 * 基于用户名分页查询日志数据
	 * @param username 用户名
	 * @param pageCurrent 当前页码
	 * @return 当前页数据
	 * @throws IllegalPageNumberException
	 * @throws RecordNotFoundException
	 */
	PageObjectVO<SysLogDO> findSysLog(String username,Integer pageCurrent) 
			throws IllegalPageNumberException, RecordNotFoundException;

}
