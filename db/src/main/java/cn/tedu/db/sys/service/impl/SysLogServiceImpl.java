package cn.tedu.db.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.db.common.aop.SysLogAnnotation;
import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.mapper.SysLogMapper;
import cn.tedu.db.sys.pojo.SysLogDO;
import cn.tedu.db.sys.service.ISysLogService;
import cn.tedu.db.sys.service.ex.DeleteException;
import cn.tedu.db.sys.service.ex.EmptyIdException;
import cn.tedu.db.sys.service.ex.IllegalPageNumberException;
import cn.tedu.db.sys.service.ex.RecordNotFoundException;

@Service
public class SysLogServiceImpl implements ISysLogService {
	
	@Autowired
	SysLogMapper mapper;
	
	Integer pageSize=2;
	
	@Override
	@Transactional
	@SysLogAnnotation(operation = "删除日志")
	public void removeSysLog(Integer[] ids) 
			throws EmptyIdException, DeleteException{
		// 判断ids是否为null或者长度为0
		if(ids==null || ids.length==0) {
			// 是：EmptyIdException
			throw new EmptyIdException("删除日志异常！id数组为空");
		}

		// 调用持久层执行删除日志操作
		Integer row=0;
		try {
			row=mapper.deleteSysLog(ids);
		} catch (Exception e) {
			e.printStackTrace();
			// 捕获受检异常，封装成自定义异常
			throw new DeleteException("删除日志异常！持久层方法执行异常！", e);
		}
		
		// 判断返回值是否与ids长度不一致
		if(row!=ids.length) {
			// 是：DeleteException
			throw new DeleteException("删除日志异常！存在未删除成功的记录");
		}
	}

	@Override
	@SysLogAnnotation(operation = "查询日志")
	public PageObjectVO<SysLogDO> findSysLog(String username, Integer pageCurrent)
			throws IllegalPageNumberException, RecordNotFoundException {
		// 判断pageCurrent是否为null或者小于1
		if(pageCurrent==null || pageCurrent<1) {
			// 是：IllegalPageNumberException
			throw new IllegalPageNumberException("查询日志异常！页码不正确");
		}

		// 调用持久层方法，查询rowCount
		Integer rowCount=mapper.getRowCount(username);
		// 判断rowCount是否为0
		if(rowCount==0) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询日志异常！总数据条数为0");
		}

		// 计算生成recordIndex
		Integer recordIndex=(pageCurrent-1)*pageSize;
		// 调用持久层方法，查询当前页数据
		List<SysLogDO> pageRecord=mapper.getPageRecord(username, recordIndex, pageSize);
		// 判断查询结果是否为null或者长度为0
		if(pageRecord==null || pageRecord.size()==0) {
			// 是：RecordNotFoundException
			throw new RecordNotFoundException("查询日志异常！未查询到相关记录");
		}

		// 创建PageObjectVO对象
		PageObjectVO<SysLogDO> vo=new PageObjectVO<SysLogDO>();
		// 向PageObjectVO对象中填充数据
		vo.setPageCount((rowCount-1)/pageSize+1);
		vo.setPageCurrent(pageCurrent);
		vo.setPageRecord(pageRecord);
		vo.setPageSize(pageSize);
		vo.setRowCount(rowCount);
		// 返回pageObject对象
		return vo;
	}



}
