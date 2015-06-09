package com.umbrella.spring.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.umbrella.spring.controller.HelloWorldController;

@Component
public class PostBeanInstantiation implements BeanPostProcessor, Ordered {
	
	private static Logger log = LoggerFactory.getLogger(PostBeanInstantiation.class);

	/**
	 * arg0 bean对象
	 * arg1 bean对象的id
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg0 instanceof HelloWorldController) log.info(arg1 + " 初始化前执行");
		return arg0;
	}
	
	/*
	 * 这之间会依次执行
	 * @PostConstruct
	 * InitializingBean.afterPropertiesSet()
	 * <bean init-method="init()" />
	 * 
	 */
	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg0 instanceof HelloWorldController) log.info(arg1 + " 初始化后执行");
		return arg0;
	}

	@Override
	public int getOrder() {
		return 10;
	}

}
