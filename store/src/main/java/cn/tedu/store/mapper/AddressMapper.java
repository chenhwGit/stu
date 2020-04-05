package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Address;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午6:30:18
 * @description 描述：处理用户收货地址数据的持久层接口
 */
public interface AddressMapper {
	/**
	 * 添加用户收货地址
	 * 
	 * @param address 封装了用户收货地址的类
	 * @return 受影响的行数
	 */
	Integer insert(Address address);

	/**
	 * 根据收货地址id删除收货地址数据
	 * 
	 * @param aid 收货地址id
	 * @return 受影响的行数
	 */
	Integer deleteByAid(Integer aid);

	/**
	 * 根据用户id将地址全部设置为非默认
	 * 
	 * @param uid 用户id
	 * @return 返回受影响行数
	 */
	Integer updateNonDefaultByUid(Integer uid);

	/**
	 * 根据收货地址id设置默认
	 * 
	 * @param aid          收货地址id
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时间
	 * @return 受影响的行数
	 */
	Integer updateDefaultByAid(@Param("aid") Integer aid, @Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);

	/**
	 * 统计收货地址数量
	 * 
	 * @param uid 用户id
	 * @return 受影响的行数
	 */
	Integer countByUid(Integer uid);

	/**
	 * 查询收货地址
	 * 
	 * @param uid 用户id
	 * @return 返回数据集合
	 */
	List<Address> findByUid(Integer uid);

	/**
	 * 根据收货地址id查找数据是否存在
	 * 
	 * @param aid 用户id
	 * @return 收货地址数据,不存在则返回null
	 */
	Address findByAid(Integer aid);

	/**
	 * 查询某用户最近修改的收货地址
	 * 
	 * @param uid 用户id
	 * @return 该用户最近修改的收货地址数据
	 */
	Address findLastModified(Integer uid);

}
