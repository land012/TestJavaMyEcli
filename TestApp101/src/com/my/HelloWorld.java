package com.my;

import java.text.DecimalFormat;


public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println("Hello World!!");
		
//		System.out.println(Math.pow(2, 8));
		
//		for(int i=0; i<15; i++) {
//			System.out.println("ÄãºÃ" + i + "<br/>");
//		}
		
//		int i1 = 2;
//		int i2 = 1;
//		System.out.println(i1>i2);
//		System.out.println(i1>i2?false:true);
		
		
		DecimalFormat df = new DecimalFormat("0000");
		for(int i=1; i<=59; i++) {
			String name = df.format(i);
			System.out.println("<img src=\"" + name + ".jpg\" />");
		}
		
	}

}
