package com.xyz.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextUtil {
	private static ApplicationContext applicationContext;
	
	private static WebApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		if(null == applicationContext) {
			applicationContext = new ClassPathXmlApplicationContext(new String[]{ "applicationContext.xml" });
		}
		return applicationContext;
	}
	
	public static WebApplicationContext getWebApplicationContext(HttpServletRequest request) {
		return WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
	}
	
	public static WebApplicationContext getWebApplicationContext(HttpSession session) {
		return WebApplicationContextUtils.getWebApplicationContext(session.getServletContext());
	}
	
	public static Object getBean(HttpServletRequest request, String name) {
		if(null == ctx) {
			ctx = getWebApplicationContext(request);
		}
		if(null != ctx) {
			return ctx.getBean(name);
		}
		return null;
	}
	
	public static Object getBean(HttpSession session, String name) {
		if(null == ctx) {
			ctx = getWebApplicationContext(session);
		}
		if(null != ctx) {
			return ctx.getBean(name);
		}
		return null;
	}
}
