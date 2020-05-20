package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author 作者：chen
 * @email 邮箱：727424623@qq.com
 * @version v.1.0 创建时间：上午11:50:40
 * @description 描述：切面类
 */
@Component
@Aspect
public class TimerAspect {

	@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
	public Object aaa(ProceedingJoinPoint pjp) throws Throwable {

		// 记录起始时间
		long start = System.currentTimeMillis();

		// 执行Service中的方法，例如用户注册,或用户登录等
		Object result = pjp.proceed();

		// 记录结束时间并对比
		long end = System.currentTimeMillis();
		System.err.println("执行耗时:" + (end - start) + "毫秒");
		return result;
	}
}
