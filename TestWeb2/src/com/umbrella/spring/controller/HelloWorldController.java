package com.umbrella.spring.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.umbrella.spring.service.HelloWorldService;
import com.umbrella.spring.util.WebAppContextUtil1;

@Controller("helloWorldController")
//@Lazy
public class HelloWorldController implements InitializingBean, DisposableBean, BeanNameAware {
	
	private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);
	
	private String beanName;
	
	/*
	 * ֻ��  HelloWorldServiceImpl ָ�� @Lazy�������ӳټ���
	 * ���  HelloWorldServiceImpl ��ָ�� @Lazy�������˴��� HelloWorldController ָ�� @Lazy,Ҳ�����ӳټ���
	 */
	@Autowired
	@Qualifier("helloWorldService")
	@Lazy
	HelloWorldService helloWorldService;
	
	/*
	 * �Զ�װ�� List
	 */
	@Autowired
	List<HelloWorldService> lists;
	
	/**
	 * ʵ����
	 */
	public HelloWorldController() {
		log.info("this is HelloWorldController()");
	}
	
	/**
	 * ����������� populate property֮�󣬳�ʼ��֮ǰִ��
	 */
	@Override
	public void setBeanName(String arg0) {
		this.beanName = arg0;
		log.info("this is setBeanName(), beanName=" + this.beanName);
	}
	
	@PostConstruct
	public void postConstruct() {
		log.info("this is postConstruct()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("this is afterPropertiesSet()");
	}
	
	@RequestMapping("/hello")
	public String hello(HttpServletRequest req, Model model) {
		log.info(helloWorldService.hello());
		if(lists == null) {
			log.info("lists is null");
		} else {
			log.info("lists.size=" + lists.size());
		}
		model.addAttribute("helloworld", "Hello");
		Cookie[] cookies = req.getCookies();
		for(Cookie cookie : cookies) {
			log.info(cookie.getName() + "=" + cookie.getValue());
		}
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public String hello2(Model model) {
		HelloWorldService service = WebAppContextUtil1.getApplicationContext().getBean("helloWorldService", HelloWorldService.class);
		log.info(service.hello());
		model.addAttribute("helloworld", "Hello2");
		return "hello";
	}

	@Override
	public void destroy() throws Exception {
		log.info("this is destroy()");
	}

}
