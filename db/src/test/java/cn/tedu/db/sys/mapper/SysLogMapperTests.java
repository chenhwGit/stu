package cn.tedu.db.sys.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.sys.pojo.SysLogDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogMapperTests {
	
	@Autowired
	SysLogMapper mapper;
	
	@Test
	public void insertSysLog() {
		SysLogDO sysLogDO=new SysLogDO(null, "tester", "测试操作", 
				"cn.tedu.test...", "abc", 100L, "127.0.0.1", null);
		Integer row=mapper.insertSysLog(sysLogDO);
		System.err.println("row="+row);
	}
	
	@Test
	public void deleteSysLog() {
		Integer[] ids= {9,10,11};
		Integer row=mapper.deleteSysLog(ids);
		System.err.println("row="+row);
	}
	
	@Test
	public void getRowCount() {
		Integer count=mapper.getRowCount("tom");
		System.err.println("count="+count);
	}
	
	@Test
	public void getPageRecord() {
		List<SysLogDO> list=mapper.getPageRecord("admin", 0, 5);
		for(SysLogDO item:list) {
			System.err.println(item);
		}
	}

}
