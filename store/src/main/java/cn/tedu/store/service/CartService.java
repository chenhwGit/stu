package cn.tedu.store.service;

import java.util.List;

import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:39:19
 * @description 描述：
 */
public interface CartService {
	/**
	 * 添加商品
	 * 
	 * @param uid      归属用户的id
	 * @param username 最后修改人
	 * @param pid      商品id
	 * @param amount   商品数量
	 */
	void addToCart(Integer uid, String username, Integer pid, Integer amount);

	/**
	 * 删除某用户的若干个购物车数据
	 * 
	 * @param cids 若干个数据id
	 * @param uid  用户归属id
	 */
	void delete(Integer[] cids, Integer uid);

	/**
	 * 根据用户id查询购物车商品信息
	 * 
	 * @param uid 用户id
	 * @return 返回用户购物车信息
	 */
	List<CartVO> getByUid(Integer uid);

	/**
	 * 增加购物车商品数量
	 * 
	 * @param cid      购物车id
	 * @param uid      用户id
	 * @param username 最后修改人
	 */
	void addNum(Integer cid, Integer uid, String username);

	/**
	 * 减少购物车商品数量
	 * 
	 * @param cid      购物车id
	 * @param uid      用户id
	 * @param username 最后修改人
	 */
	void reduceNum(Integer cid, Integer uid, String username);

	/**
	 * 查询若干个数据id匹配的购物车列表
	 * 
	 * @param cids 若干个数据id
	 * @param uid  用户的id
	 * @return 匹配的购物车列表
	 */
	List<CartVO> getByCids(Integer[] cids, Integer uid);
}
