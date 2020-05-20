package cn.tedu.db.sys.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.db.common.pojo.PageObjectVO;
import cn.tedu.db.sys.pojo.SysLogDO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogServiceTests {
	
	@Autowired
	ISysLogService service;
	
	@Test
	public void removeSysLog() {
		Integer[] ids= {14,15,16};
		service.removeSysLog(ids);
	}
	
	@Test
	public void findSysLog() {
		PageObjectVO<SysLogDO> vo=service.findSysLog("sdfsdf", 1);
		System.err.println(vo);
	}

}



