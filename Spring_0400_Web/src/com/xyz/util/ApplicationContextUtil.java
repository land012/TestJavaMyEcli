package com.xyz.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static ApplicationContext applicationContext;
	
	public static ApplicationContext getInstance() {
		if(null == applicationContext) {
			applicationContext = new ClassPathXmlApplicationContext(new String[]{""});
		}
		return applicationContext;
	}
}
