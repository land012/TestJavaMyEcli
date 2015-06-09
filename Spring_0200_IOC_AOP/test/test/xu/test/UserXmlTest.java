package test.xu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.com.xu.model.User;
import xml.com.xu.service.UserService;


public class UserXmlTest {
	private ApplicationContext applicationContext;
	
	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext(new String[]{ "xmlbeans.xml" });
	}
	
	@Test
	public void testComponent2() {
		UserService userService = (UserService)applicationContext.getBean("userService");
		User u = new User();
		userService.save(u);
	}
}
