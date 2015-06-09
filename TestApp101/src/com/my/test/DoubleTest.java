package com.my.test;


import com.my.base.BaseTest;

public class DoubleTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		double d1 = 100.0;
//		double d2 = 100.0;
//		if(d1 != d2) {
//			info.info("不相等！");
//		} else {
//			info.info("相等！");
//		}
		
		// 异常 java.lang.NumberFormatException: empty String
//		info.info(Double.parseDouble(""));
		
		info.info(1/2);
		info.info(1%2);
		
	}

}
