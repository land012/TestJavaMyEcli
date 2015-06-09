package test.com.xyz.dao;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyz.model.User;
import com.xyz.service.UserService;

public class UserServiceTest {
	
	private static ApplicationContext ctx;
	private static UserService userService;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext(new String[]{ "classpath:applicationContext2.xml" });
		/*
		 * ·ºÐÍ
		 */
		userService = ctx.getBean("userService", UserService.class);
	}
	
	@Test
	public void test1() {
		User u = new User();
		u.setUsername("tom");
		Assert.assertTrue(userService.save(u));
	}
}
