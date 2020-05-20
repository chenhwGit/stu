package cn.tedu.db.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.db.sys.pojo.SysLogDO;

/**
 * 日志模块的持久层接口
 */
public interface SysLogMapper {
	
	/**
	 * 添加日志记录
	 * @param sysLogDO 新的日志信息
	 * @return 添加成功的数据条数
	 */
	Integer insertSysLog(SysLogDO sysLogDO);
	
	/**
	 * 基于日志id删除日志记录
	 * @param ids 日志id的数组
	 * @return 删除成功的记录条数
	 */
	Integer deleteSysLog(@Param("ids")Integer[] ids);
	
	/**
	 * 基于用户名查询总数据条数
	 *  
	 * 如果一个方法的参数会被用于动态SQL语句，
	 * 即使该方法仅有1个参数，
	 * 也必须在该参数前添加@Param注解
	 * @param username 用户名
	 * @return 数据条数
	 */
	Integer getRowCount(@Param("username")String username);

	/**
	 * 基于用户名分页查询数据
	 * @param username 用户名
	 * @param recordIndex 跳过的数据条数
	 * @param pageSize 查询的数据条数
	 * @return 当前页数据
	 */
	List<SysLogDO> getPageRecord(
					@Param("username")String username,
					@Param("recordIndex")Integer recordIndex,
					@Param("pageSize")Integer pageSize);

}
