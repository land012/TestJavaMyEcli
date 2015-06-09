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
			System.out.println("����������Ͳ���ȷ������");
		}
		return res;
	}
	
	private void before() {
		System.out.println("before,���Ǵ�����Ҫ��5Ԫ������");
	}
	
	private void after() {
		System.out.println("after,���Ǵ���������5Ԫ������");
	}

}
