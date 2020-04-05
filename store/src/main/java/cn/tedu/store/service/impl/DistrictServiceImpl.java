package cn.tedu.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.District;
import cn.tedu.store.mapper.DistrictMapper;
import cn.tedu.store.service.DistrictService;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午11:47:09
 * @description 描述：处理省市区数据的业务层实现类
 */
@Service
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	private DistrictMapper mapper;

	@Override
	public List<District> getByParent(String parent) {
		List<District> list = mapper.findByParent(parent);
		for (District district : list) {
			district.setId(null);
			district.setParent(null);
		}
		return list;
	}

	@Override
	public String getNameByCode(String code) {
		return mapper.findNameByCode(code);
	}

}
