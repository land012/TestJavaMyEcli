package com.my.test;

public class StringBuilderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// StringBuilder ≤‚ ‘
		StringBuilder sb1 = new StringBuilder();
		System.out.println(sb1.capacity()); // 16
		sb1.append("abcdef");
		System.out.println(sb1.capacity()); // 16
		
		StringBuilder sb2 = new StringBuilder(20);
		System.out.println(sb2.capacity()); // 20
		sb2.append("abcdef");
		System.out.println(sb2.capacity()); // 20
	}

}
