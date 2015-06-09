package com.xu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogIntercepter {
	
	@Before("execution(public void com.xu.dao.impl.UserDaoImpl.save(com.xu.model.User))")
	public void before() {
		System.out.println("log before");
	}
	
	// 作为 pointcut
	@Pointcut("execution(public * com.xu.service..*.*(..))")
	public void adviceUserService() {}
	
	@Around("adviceUserService()") // 上面的方法 adviceUserService() 的名
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start");
		pjp.proceed();
		System.out.println("around end");
	}
}
