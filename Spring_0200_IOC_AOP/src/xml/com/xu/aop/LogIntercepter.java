package xml.com.xu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
@Component
public class LogIntercepter {
	
	public void before() {
		System.out.println("log before");
	}
	
	public void around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("around start");
		pjp.proceed();
		System.out.println("around end");
	}
}
