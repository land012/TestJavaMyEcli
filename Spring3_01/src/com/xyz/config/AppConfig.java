package com.xyz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyz.bean.MyBean;
import com.xyz.dao.UserDao;
import com.xyz.dao.impl.UserDaoImpl;
import com.xyz.service.UserService;
import com.xyz.service.impl.UserServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public UserService userService() {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserDao(userDao());
		return userService;
	}
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}
}
