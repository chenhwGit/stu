package cn.tedu.store.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.entity.Product;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午5:31:12
 * @description 描述：
 */
public interface ProductMapper {
	/**
	 * 查询热销排行
	 * 
	 * @return 返回热销排行的数据集
	 */
	List<Product> findHotList();

	/**
	 * 修改库存
	 * 
	 * @param id           商品id
	 * @param num          新的库存值
	 * @param modifiedUser 最后修改人
	 * @param modifiedTime 最后修改时间
	 * @return 受影响的行数
	 */
	Integer updateNumById(@Param("id") Integer id, @Param("num") Integer num,
			@Param("modifiedUser") String modifiedUser, @Param("modifiedTime") Date modifiedTime);

	/**
	 * 查找商品
	 * 
	 * @param id 商品id
	 * @return 商品数据信息
	 */
	Product findById(Integer id);

}
