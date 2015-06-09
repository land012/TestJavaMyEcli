package test.com.my.extend;

import org.junit.Test;

import com.my.test.extend.A;
import com.my.test.extend.B;

public class TestExtend {
	@Test
	public void testExt1() {
		A a1 = new B();
		a1.fn1();
		
		try {
			A a2 = (A)Class.forName("com.my.extend.B").newInstance(); // B
			a2.fn1();
			
			A a3 = new A();
//			a2 = a3; // A
//			a2.fn1();
			
			a2 = getA(a2, a3);
			a2.fn1();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private A getA(A a1, A a2) {
		return a1;
	}
}
