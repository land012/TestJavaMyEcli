package test.xu.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xu.test.TestBean;

public class TestBeanTest {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext(new String[]{ "beans.xml" });
	}
	
	@Test
	public void test1() {
		TestBean t1 = (TestBean)applicationContext.getBean("testBean");
		t1.printList();
	}
}
