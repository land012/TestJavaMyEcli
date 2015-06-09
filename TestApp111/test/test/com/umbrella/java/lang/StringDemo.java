package test.com.umbrella.java.lang;

import org.junit.Before;
import org.junit.Test;

public class StringDemo {
	
	private static final int TIMES = 100000;
	
	@Before
	public void before() {
		
	}
	
	/**
	 * String
	 */
	@Test
	public void test1() {
		String temp = "abcdefghijklmnopqrstuvwxyz"; // String Constant Pool
		long start1 = System.currentTimeMillis();
		String str1 = "";
		for(int i=0; i<TIMES; i++) {
			str1 += temp;
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 1322
	}
	
	/**
	 * StringBuilder
	 */
	@Test
	public void test2() {
		String temp = "abcdefghijklmnopqrstuvwxyz";
		long start1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<TIMES; i++) {
			sb1.append(temp);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}
	
	@Test
	public void test3() {
		long start1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<TIMES; i++) {
			sb1.append("abcdefghijklmnopqrstuvwxyz"); // String Constant Pool
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}
	
	/**
	 * StringBuffer
	 */
	@Test
	public void test4() {
		String temp = "abcdefghijklmnopqrstuvwxyz";
		long start1 = System.currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for(int i=0; i<TIMES; i++) {
			sb1.append(temp);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}
}
