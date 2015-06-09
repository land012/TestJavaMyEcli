package test.xu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.com.xu.model.Student;
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
		u.setName("tom" + getRndNum());
		userService.save(u);
	}
	
	@Test
	public void testSaveStudent() {
		UserService userService = (UserService)applicationContext.getBean("userService");
		Student s = new Student();
		s.setName("tom");
		userService.save(s);
	}
	
	@Test
	public void test1() {
		double d1 = Math.random()*1000;
		String d1Str = String.valueOf(d1);
		int dotindex = d1Str.indexOf(".");
		d1Str = d1Str.substring(0, dotindex);
		
		System.out.println(d1Str);
	}
	
	private String getRndNum() {
		double d1 = Math.random()*1000;
		String d1Str = String.valueOf(d1);
		int dotindex = d1Str.indexOf(".");
		d1Str = d1Str.substring(0, dotindex);
		return d1Str;
	}
}
