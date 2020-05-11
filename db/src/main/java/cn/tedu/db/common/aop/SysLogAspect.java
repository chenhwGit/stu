package cn.tedu.db.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.db.common.util.IPUtils;
import cn.tedu.db.common.util.UserUtils;
import cn.tedu.db.sys.mapper.SysLogMapper;
import cn.tedu.db.sys.pojo.SysLogDO;

@Aspect
@Component
public class SysLogAspect {
	
	@Autowired
	SysLogMapper mapper;
	
	/**
	 * 记录日志的切面方法
	 * @param pjp 目标方法的句柄
	 * @param logAnno 目标方法上的SysLogAnnotation注解对象
	 * @return 目标方法的执行结果
	 * @throws Throwable
	 */
	@Around(value="execution(* cn.tedu.db.sys.service.impl.*.*(..))&&@annotation(logAnno)")
	public Object logAdvice(ProceedingJoinPoint pjp,SysLogAnnotation logAnno) throws Throwable {
		// 记录开始时间
	    long st=System.currentTimeMillis();
	    // 调用了目标方法
	    Object result=pjp.proceed();
	    // 记录结束时间
	    long et=System.currentTimeMillis();
		long time=et-st;
		String operation=logAnno.operation();
		// 调用方法生成日志对象并保存
		saveSysLog(pjp,time,operation);
		
		return result;
	}
	
	/**
	 * 收集日志信息并保存
	 * @param pjp 目标方法句柄
	 * @param time 目标方法执行耗时
	 * @param operation 目标操作中文描述
	 * @throws JsonProcessingException
	 */
	public void saveSysLog(ProceedingJoinPoint pjp,long time,String operation) throws JsonProcessingException {
		// 收集日志相关信息
		// username -> 通过工具类获取
		String username=UserUtils.getUsername();
		// operation -> 通过自定义注解实现
		// method
		String className=pjp.getTarget().getClass().getName();
		String method=className+"."+pjp.getSignature().getName();
		//params
		Object[] paramsObj=pjp.getArgs();
		// 使用Jackson的一个API，将对象数组转换成对应的字符串表示
		String params=new ObjectMapper().writeValueAsString(paramsObj);
		//ip -> 通过工具类获取
		String ip=IPUtils.getIpAddr();
		// 创建日志对象
		SysLogDO sysLogDO=new SysLogDO(null, username, operation, method, params, time, ip, null);
		// 将日志对象添加到数据库中
		mapper.insertSysLog(sysLogDO);
	}

}
