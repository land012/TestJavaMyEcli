package com.xu.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
	private Object target;
	
	public LogHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName() + " start " + System.currentTimeMillis());
		method.invoke(this.target, args);
		System.out.println(method.getName() + " end " + System.currentTimeMillis());
		return null;
	}

}
