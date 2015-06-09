package test.com.xyz.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.xyz.bean.MyBean;
import com.xyz.model.User;
import com.xyz.spel.template.TemplatedParserContext;

public class SpELTest {
	
	ApplicationContext ctx = null;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext(new String[]{ "applicationContext2.xml" });
	}
	
	/**
	 * 取类的属性值
	 */
	@Test
	public void test1() {
		User u = new User();
		u.setUsername("tom");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("username"); // 相当于 u.getUsername()
		System.out.println(exp.getValue(u));
	}
	
	/**
	 * 取类的属性值
	 */
	@Test
	public void test2() {
		User u = new User();
		u.setUsername("tom");
		
		EvaluationContext ctx = new StandardEvaluationContext(u); // 上下文
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("username"); // 相当于 u.getUsername()
		System.out.println(exp.getValue(ctx));
	}
	
	/**
	 * @Value
	 * 使用 spel 指定 bean 的初始属性值
	 */
	@Test
	public void test3() {
		MyBean mb = ctx.getBean("myBean", MyBean.class);
		System.out.println(mb.getRandomNumber());
		System.out.println(mb.getUesrRegion());
	}
	
	/**
	 * Expression Tempalte
	 */
	@Test
	public void test4() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("it is ${T(java.lang.Math).random()}", new TemplatedParserContext());
		System.out.println(exp.getValue(String.class));
	}
}
