package com.my.test;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.my.base.BaseTest;
/**
 * 
 * @author asdf
 * NumberUtils.isNumber(str)
 *   �ܱ������������ַ���      true
 *   С������������ѧ������ true
 * NumberUtils.isDigits(str)
 *   С��     false
 *   ����      false
 *   ȫ���� true
 * StringUtils.isNumeric(str)
 *   С��      false
 *   ����      false
 *   ȫ���� true
 *
 */
public class NumberUtilsTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "123l"; // Long��
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
		
		
		// ��ѧ���㷨
//		double d3    = 1.2E4;   // 12000
//		double d3_2  = 1.2e4;   // 12000
//		info.info(d3);
//		info.info(d3_2);
		
		/*
		 * parseDouble(str) ���Խ�����ѧ���㷨
		 */
//		String d1Str = "1.2E4";
//		info.info(Double.parseDouble(d1Str));
		
		/**
		 * NumberUtils.isNumber()
		 * NumberUtils.isDigits()
		 * StringUtils.isNumeric()
		 */
		// ������
//		String d2Str = "1212340";
//		info.info(NumberUtils.isNumber(d2Str));  // true
//		info.info(NumberUtils.isDigits(d2Str));  // true
//		info.info(StringUtils.isNumeric(d2Str)); // true
		
//		// ��
//		String d3Str = "0";
//		info.info(NumberUtils.isNumber(d3Str));  // true
//		info.info(NumberUtils.isDigits(d3Str));  // true
//		info.info(StringUtils.isNumeric(d3Str)); // true
		
//		// ����
//		String d6Str = "-23";
//		info.info(NumberUtils.isNumber(d6Str));  // true
//		info.info(NumberUtils.isDigits(d6Str));  // false
//		info.info(StringUtils.isNumeric(d6Str)); // false
		
		// С��
//		String d5Str = "12.2";
//		info.info(NumberUtils.isNumber(d5Str));  // true
//		info.info(NumberUtils.isDigits(d5Str));  // false
//		info.info(StringUtils.isNumeric(d5Str)); // false
		
		/*
		 * ��ѧ���㷨
		 */
//		String d4Str = "1.2E4"; // 12000
//		info.info(NumberUtils.isNumber(d4Str));  // true
//		info.info(NumberUtils.isDigits(d4Str));  // false �ַ����е�ÿһλ�������ֲŻ᷵�� true
//		info.info(StringUtils.isNumeric(d4Str)); // false

	}

}
