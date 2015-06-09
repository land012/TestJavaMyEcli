package test.com.umbrella.enumtest;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.umbrella.enumtest.Brush;
import com.umbrella.enumtest.Brush2;
import com.umbrella.enumtest.ColorDemo;
import com.umbrella.enumtest.ColorDemo2;

public class ColorDemoTest {
	
	private static Logger log = Logger.getLogger(ColorDemoTest.class);
	
	@Test
	public void test1() {
		Brush b = new Brush(ColorDemo.BLUE);
		b.line();
	}
	
	@Test
	public void test2() {
		Brush2 b = new Brush2(ColorDemo2.BLUE);
		b.line();
	}
}
