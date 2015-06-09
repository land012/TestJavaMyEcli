package com.umbrella.springdemo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.umbrella.springdemo.service.HelloWorldService;

public class Main {
	
	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			
			HelloWorldService helloWorldService = (HelloWorldService)ctx.getBean("helloWorldService");
			log.info(helloWorldService.getName() + "-" + helloWorldService.getAge());
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

}
