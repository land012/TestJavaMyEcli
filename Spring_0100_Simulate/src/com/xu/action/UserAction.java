package com.xu.action;

import com.xu.model.User;
import com.xu.service.UserService;
import com.xu.util.ClassPathXmlApplicationContext;

/**
 * 模拟 Spring 解析xml配置文件
 * @author asdf
 *
 */
public class UserAction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
			User u = new User();
			u.setId(1);
			u.setName("tom");
			UserService userService = (UserService)applicationContext.getBean("userService");
			userService.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
