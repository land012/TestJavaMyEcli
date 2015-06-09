package com.xu.action;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.xu.model.User;
import com.xu.service.UserService;

@Component
public class UserAction {
	
	private UserService userService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{ "beans.xml" });
			User u = new User();
			u.setId(1);
			u.setName("tom");
			UserService userService = (UserService)applicationContext.getBean("userService");
			userService.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void fn1() {
		System.out.println("User Action fn1()!");
		User u = new User();
		userService.save(u);
	}
	
	/*
	 * 
	 */
	
	public UserService getUserService() {
		return userService;
	}
	
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
