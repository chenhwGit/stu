package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Cart;
import cn.tedu.store.vo.CartVO;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午4:06:57
 * @description 描述：商品数据的持久层接口
 */
public interface CartMapper {
	/**
	 * 添加商品
	 * 
	 * @param cart 商品信息
	 * @return 受影响的行数
	 */
	Integer insert(Cart cart);

	/**
	 * 删除某用户的若干个购物车数据
	 * 
	 * @param cids 若干个数据id
	 * @param uid  用户归属id
	 * @return 受影响的行数
	 */
	Integer deleteBycids(@Param("cids") Integer[] cids, @Param("uid") Integer uid);

	/**
	 * 修改商品数量
	 * 
	 * @param cid          购物车数据id
	 * @param num          商品的数量
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时时间
	 * @return 受影响的行数
	 */
	Integer updateNumByCid(@Param("cid") Integer cid, @Param("num") Integer num,
			@Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

	/**
	 * 根据归属用户的id和商品的id查找相应的商品信息
	 * 
	 * @param uid 归属用户的id
	 * @param pid 商品的id
	 * @return 商品信息数据
	 */
	Cart findByUidAndPid(@Param("uid") Integer uid, @Param("pid") Integer pid);

	/**
	 * 通过用户id查找购物车信息
	 * 
	 * @param uid 用户归属id
	 * @return 返回数据集
	 */
	List<CartVO> findByUid(Integer uid);

	/**
	 * 根据购物车数据的id查询购物车详情
	 * 
	 * @param cid 购物车数据的id
	 * @return 匹配的购物车详情
	 */
	Cart findByCid(Integer cid);

	/**
	 * 查询若干个数据id匹配的购物车列表
	 * 
	 * @param cids 若干个数据id
	 * @return 匹配的购物车列表
	 */
	List<CartVO> findByCids(Integer[] cids);
}
