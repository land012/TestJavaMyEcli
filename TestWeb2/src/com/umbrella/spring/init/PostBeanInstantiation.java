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
	 * arg0 bean����
	 * arg1 bean�����id
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg0 instanceof HelloWorldController) log.info(arg1 + " ��ʼ��ǰִ��");
		return arg0;
	}
	
	/*
	 * ��֮�������ִ��
	 * @PostConstruct
	 * InitializingBean.afterPropertiesSet()
	 * <bean init-method="init()" />
	 * 
	 */
	
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
		if(arg0 instanceof HelloWorldController) log.info(arg1 + " ��ʼ����ִ��");
		return arg0;
	}

	@Override
	public int getOrder() {
		return 10;
	}

}
