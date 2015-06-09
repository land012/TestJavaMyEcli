package test.com.umbrella.test;

import org.junit.Test;

import com.umbrella.test.SingletonPattern;

public class SingletonPatternTest {
	@Test
	public void test1() {
		SingletonPattern.fn1();
	}
	
	@Test
	public void test2() {
		SingletonPattern.getIntance().fn2();
	}
	
	public static void main(String[] args) {
		/**
		 * µ¥Àý²¢·¢²âÊÔ
		 */
		T1 r1 = new T1();
		T1 r2 = new T1();
		r1.start();
		r2.start();
	}
	
}

class T1 extends Thread {
	@Override
	public void run() {
		SingletonPattern.getIntance2().fn2();
	}
}
