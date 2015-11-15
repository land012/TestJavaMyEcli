package com.umbrella.java.lang;

import org.junit.Test;

public class DoubleDemo {

	@Test
	public void test1() {
		double d1 = Double.parseDouble("0.0");
		System.out.println(0==d1); // true
		
		System.out.println(0 != d1); // false
	}
	
	@Test
	public void test2() {
//		try {
//		Double.parseDouble("abc");
//	} catch(NumberFormatException e) {
//		info.info("java.lang.NumberFormatException");
//	}
//	try {
//		Double.parseDouble(null);
//	} catch(NullPointerException e) {
//		info.info("java.lang.NullPointerException");
//	}
	
//	Double d = new Double("299.40");
//	int i = (int)d.doubleValue();
//	System.out.println(i);
//	
//	double d1 = 299.9;
//	int i1 = (int)d1;
//	System.out.println(i1);
		
//		Double d1 = new Double("299.40");
//		float f1 = (float)d1.doubleValue();
//		System.out.println(f1);
	}

}