package com.my.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

import com.my.base.BaseTest;

public class DecimalFormatTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		DecimalFormat df1 = new DecimalFormat("#");
//		double d = 123.343;
//		info.info(df1.format(d));
		
//		DecimalFormat df1 = new DecimalFormat("#");
//		df1.setRoundingMode(RoundingMode.FLOOR);
//		String str1 = "123.9";
//		try {
//			System.out.println(df1.parse(str1));
//			System.out.println(df1.format(df1.parse(str1)));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		
		// java.lang.ClassCastException: java.lang.Long cannot be cast to java.lang.Double
//		String str2 = "123.00";
//		DecimalFormat df2 = new DecimalFormat("#");
//		try {
//			Number d2 = (Double)df2.parse(str2);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
//		Double d1 = new Double("123.0");
//		try {
//			System.out.println(new DecimalFormat("#.#").parse("212.56").doubleValue());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		DecimalFormat df = new DecimalFormat("0.#");
		try {
			System.out.println(df.parse("20.34"));            // 20.34
			
			System.out.println(df.parse("20.01"));            // 20.01
			System.out.println(df.format(df.parse("20.01"))); // 20
			
			System.out.println(df.format(20.35));             // 20.4
			System.out.println(df.format(20.34));             // 20.3
			System.out.println(df.format(new Double(20.56))); // 20.6
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
