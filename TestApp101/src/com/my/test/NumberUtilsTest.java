package com.my.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.my.base.BaseTest;
/**
 * 
 * @author asdf
 * NumberUtils.isNumber(str)
 *   能被解析的数字字符串      true
 *   小数，负数，科学计数法 true
 * NumberUtils.isDigits(str)
 *   小数     false
 *   负数      false
 *   全数字 true
 * StringUtils.isNumeric(str)
 *   小数      false
 *   负数      false
 *   全数字 true
 *
 */
public class NumberUtilsTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "123l"; // Long型
//		if(NumberUtils.isDigits(str1)) {
//			info.info(str1 + " is digits!");
//		} else {
//			info.info(str1 + " not digits!");
//		}
//		if(NumberUtils.isNumber(str1)) {
//			info.info(str1 + " is number!");
//		} else {
//			info.info(str1 + " not number!");
//		}
		
		
		// 科学计算法
//		double d3    = 1.2E4;   // 12000
//		double d3_2  = 1.2e4;   // 12000
//		info.info(d3);
//		info.info(d3_2);
		
		/*
		 * parseDouble(str) 可以解析科学计算法
		 */
//		String d1Str = "1.2E4";
//		info.info(Double.parseDouble(d1Str));
		
		/**
		 * NumberUtils.isNumber()
		 * NumberUtils.isDigits()
		 * StringUtils.isNumeric()
		 */
		// 正整数
//		String d2Str = "1212340";
//		info.info(NumberUtils.isNumber(d2Str));  // true
//		info.info(NumberUtils.isDigits(d2Str));  // true
//		info.info(StringUtils.isNumeric(d2Str)); // true
		
//		// 零
//		String d3Str = "0";
//		info.info(NumberUtils.isNumber(d3Str));  // true
//		info.info(NumberUtils.isDigits(d3Str));  // true
//		info.info(StringUtils.isNumeric(d3Str)); // true
		
//		// 负数
//		String d6Str = "-23";
//		info.info(NumberUtils.isNumber(d6Str));  // true
//		info.info(NumberUtils.isDigits(d6Str));  // false
//		info.info(StringUtils.isNumeric(d6Str)); // false
		
		// 小数
//		String d5Str = "12.2";
//		info.info(NumberUtils.isNumber(d5Str));  // true
//		info.info(NumberUtils.isDigits(d5Str));  // false
//		info.info(StringUtils.isNumeric(d5Str)); // false
		
		/*
		 * 科学计算法
		 */
//		String d4Str = "1.2E4"; // 12000
//		info.info(NumberUtils.isNumber(d4Str));  // true
//		info.info(NumberUtils.isDigits(d4Str));  // false 字符串中的每一位都是数字才会返回 true
//		info.info(StringUtils.isNumeric(d4Str)); // false

	}

}
