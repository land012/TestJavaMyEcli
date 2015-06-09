package test.xu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xu.action.UserAction;
import com.xu.model.User;
import com.xu.service.UserService;


public class UserTest {
	private ApplicationContext applicationContext;
	
	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext(new String[]{ "beans.xml" });
	}
	
	/**
	 * Å×Òì³£
	 */
	@Test
	public void testComponent1() {
		UserAction userAction = new UserAction();
		userAction.fn1();
	}
	/* ²»Å×Òì³£ */
	@Test
	public void testComponent1_2() {
		UserAction userAction = (UserAction)applicationContext.getBean("userAction");
		userAction.fn1();
	}
	
	@Test
	public void testComponent2() {
		UserService userService = (UserService)applicationContext.getBean("userService");
		User u = new User();
		userService.save(u);
	}
}
