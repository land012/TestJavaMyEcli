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
	
	@Pointcut("execution(public * com.xu.service..*.*(..))")
	public void adviceUserService() {}
	
	@Before("execution(public void com.xu.dao.impl.UserDaoImpl.save(com.xu.model.User))")
	public void before() {
		System.out.println("log before");
	}
	
	@Around("adviceUserService()")
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start");
		pjp.proceed();
		System.out.println("around end");
	}
}
