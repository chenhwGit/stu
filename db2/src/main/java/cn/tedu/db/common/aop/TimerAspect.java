package cn.tedu.db.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAspect {
	
	@Around(value="execution(* cn.tedu.db.sys.service.impl.*.*(..))")
	public Object a1(ProceedingJoinPoint pjp) throws Throwable {
	    // 记录开始时间
	    long st=System.currentTimeMillis();
	    // 调用了目标方法
	    Object result=pjp.proceed();
	    // 记录结束时间
	    long et=System.currentTimeMillis();
	    // 输出耗时
	    System.err.println("业务层=>"+pjp.getSignature().getName()+"-> 耗时："+(et-st)+"ms.");
	    return result;
	}
	
	@Around(value="execution(* cn.tedu.db.sys.mapper.*.*(..))")
	public Object a2(ProceedingJoinPoint pjp) throws Throwable {
	    // 记录开始时间
	    long st=System.currentTimeMillis();
	    // 调用了目标方法
	    Object result=pjp.proceed();
	    // 记录结束时间
	    long et=System.currentTimeMillis();
	    // 输出耗时
	    System.err.println("持久层=>"+pjp.getSignature().getName()+"-> 耗时："+(et-st)+"ms.");
	    return result;
	}
}
