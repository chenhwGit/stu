package cn.tedu.store.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.tedu.store.entity.Address;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午11:43:47
 * @description 描述：处理用户收货地址数据的业务接口
 */
public interface AddressService {
	/**
	 * 添加用户收货地址
	 * 
	 * @param uid      用户id
	 * @param username 用户名
	 * @param address  收货地址数据
	 */
	void addnew(Integer uid, String username, Address address);

	/**
	 * 删除收货地址
	 * 
	 * @param aid      收货地址id
	 * @param uid      用户id
	 * @param username 最后修改人
	 */
	void delete(Integer aid, Integer uid, String username);

	/**
	 * 根据用户id查找所有收货地址的数据
	 * 
	 * @param uid 用户id
	 * @return 返回数据集合
	 */
	List<Address> getByUid(Integer uid);

	/**
	 * 设置默认地址
	 * 
	 * @param aid      收货地址id
	 * @param uid      用户id
	 * @param username 最后修改人
	 */
	void setDefault(Integer aid, Integer uid, String username);
	
	/**
	 * 根据收货地址id查询收货地址详情
	 * @param aid 收货地址id
	 * @return 匹配的收货地址详情 ,没有则但会null
	 */
	Address getByAid(Integer aid);
}
