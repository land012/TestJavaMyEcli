package com.my.test3;

public class T3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 运算符
		double dividend = 10;
		double divisor = 3;
		System.out.println(dividend);
		System.out.println(dividend/divisor);
		
		double d = 10.0/3.0;
		System.out.println(10/3); // 得到商
		System.out.println(10.0/3.0); // 得到浮点数
		System.out.println(10.0/3); // 得到浮点数
		System.out.println(10/3.0); // 得到浮点数
		System.out.println(17/9);
		
		double d2 = 0;
		System.out.println(d2);
		
		//System.out.println(5/0); // ArithmeticException / by zero
		System.out.println(Integer.valueOf(0).doubleValue());
		
		int i = 1;
		double d3 = (double)i;
		System.out.println(d3);
	}

}
