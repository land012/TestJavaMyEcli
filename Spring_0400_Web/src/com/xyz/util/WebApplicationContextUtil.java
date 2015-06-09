package com.xyz.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebApplicationContextUtil {
	private static WebApplicationContext webApplicationContext;
	
	public static WebApplicationContext getInstance(HttpServletRequest request) {
		if(null == webApplicationContext) {
			WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		}
		return webApplicationContext;
	}
	
	public Object getBean(HttpServletRequest request, String name) {
		return getInstance(request).getBean(name);
	}
}
