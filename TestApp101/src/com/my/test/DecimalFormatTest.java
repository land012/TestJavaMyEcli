package com.my.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

import org.junit.Test;

import com.my.base.BaseTest;

/**
 * 
 * @author xudazhou
 * 验证 DecimalFormat
 *
 */
public class DecimalFormatTest extends BaseTest {

	@Test
	public void test1() {
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
	
	/**
	 * 要截断的部分的舍入
	 * 小于等于 50时，舍
	 * 大于50时，入
	 */
	@Test
	public void test2() {
		// 默认舍入规则 RoundingMode.HALF_EVEN
		DecimalFormat df1 = new DecimalFormat("#.00");
		
		System.out.println(df1.format(12.345));  // 12.34  五舍 50
		System.out.println(df1.format(12.3450)); // 12.34 五舍 50
		System.out.println("========= 1 ==========");
		System.out.println(df1.format(12.34501)); // 12.35 五入 501
		System.out.println(df1.format(12.3451));  // 12.35 五入 51
		System.out.println(df1.format(12.3454));  // 12.35 五入 54
		System.out.println("========= 2 ==========");
		System.out.println(df1.format(12.346)); // 12.35 六入 60
		
		System.out.println(df1.format(789.1245)); // 789.12 四舍 45
		System.out.println(df1.format(789.1254)); // 789.13 五入 54
		
		System.out.println(df1.format(4552.655)); // 4552.66  五入 50
		System.out.println(df1.format(4552.645)); // 4552.65  五舍 50
		
		
	}

}
