package cn.tedu.store.mapper;

import java.util.List;

import cn.tedu.store.entity.District;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：下午4:32:15
 * @description 描述：
 */
public interface DistrictMapper {
	/**
	 * 获取全国所有省，或获取某省所有市，或某市所有区的列表
	 * 
	 * @param parent 父级单位的行政代号,如果获取某市所有区的列表，该参数应该是市的行政代号，如果获取某省所有市的列表，该参数应该是省的行政代码，如果获取全国所有省的列表，该参数值使用“86”
	 * @return 全国所有省，或获取某省所有市，或某市所有区的列表
	 */
	List<District> findByParent(String parent);

	/**
	 * 根据省/市/区的行政对该查询名称
	 * 
	 * @param code 省/市/区的行政代号
	 * @return 省/市/区的名称,没有匹配的数据，则返回null
	 */
	String findNameByCode(String code);
}
