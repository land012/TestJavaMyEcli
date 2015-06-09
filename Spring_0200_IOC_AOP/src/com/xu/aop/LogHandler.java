package com.xu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * Java代理模式
 * @author asdf
 *
 */
public class LogHandler implements InvocationHandler {
	private Object target;
	
	public LogHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(System.nanoTime() + " " + method.getName() + " begin ");
		method.invoke(this.target, args);
		System.out.println(System.nanoTime() + " " + method.getName() + " end ");
		return null;
	}

}
