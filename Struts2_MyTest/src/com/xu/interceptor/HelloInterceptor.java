package com.xu.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class HelloInterceptor extends AbstractInterceptor {
	
	private static final Logger log = Logger.getLogger(HelloInterceptor.class);

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		log.info("I am HelloInterceptor");
		return arg0.invoke();
	}

}
