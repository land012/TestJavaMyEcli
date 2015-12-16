package com.umbrella.main;

import java.math.BigDecimal;

import org.junit.Test;

public class BigDecimalDemo {
	@Test
	public void test1() {
		BigDecimal b1 = new BigDecimal(0);
		double d2 = 0.000000d;
		BigDecimal b2 = new BigDecimal(d2);
		BigDecimal b3 = new BigDecimal("0.0000");
		
		System.out.println(b1); // 0
		System.out.println(b2); // 0
		System.out.println(b3); // 0.0000
		
		System.out.println(b1.equals(b2)); // true
		System.out.println(BigDecimal.ZERO.equals(b1)); // true
		System.out.println(BigDecimal.ZERO.equals(b2)); // true
		System.out.println(BigDecimal.ZERO.equals(b3)); // false
	}
}
