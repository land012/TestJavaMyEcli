package com.umbrella.designpattern.proxy.p2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class SellTicketHandler implements InvocationHandler {
	
	private Object obj;
	
	public SellTicketHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object res = null;
		if(proxy instanceof SellTicket) {
			before();
			res = method.invoke(obj, args);
			after();
		} else {
			System.out.println("代理对象类型不正确出错了");
		}
		return res;
	}
	
	private void before() {
		System.out.println("before,我是代理，我要收5元手续费");
	}
	
	private void after() {
		System.out.println("after,我是代理，我收了5元手续费");
	}

}
