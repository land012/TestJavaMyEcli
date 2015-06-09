package com.my.test;

import com.my.base.BaseTest;

public class CreditCardRatioTest extends BaseTest {

	/**
	 * 计算信用卡借现利息
	 * @param args
	 */
	public static void main(String[] args) {
		info.info(cal(4000,48));
	}
	
	/**
	 * 
	 * @param capital 本金
	 * @param mcount  月数
	 * @return
	 */
	public static double cal(double capital, double mcount) {
		double rs = capital;
		for(int i=1; i<= mcount; i++) {
			rs = rs + rs * 0.015;            // 第二个月
		}
		return rs;
	}

}
