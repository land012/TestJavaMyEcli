package com.my.test;

import com.my.base.BaseTest;

public class CreditCardRatioTest extends BaseTest {

	/**
	 * �������ÿ�������Ϣ
	 * @param args
	 */
	public static void main(String[] args) {
		info.info(cal(4000,48));
	}
	
	/**
	 * 
	 * @param capital ����
	 * @param mcount  ����
	 * @return
	 */
	public static double cal(double capital, double mcount) {
		double rs = capital;
		for(int i=1; i<= mcount; i++) {
			rs = rs + rs * 0.015;            // �ڶ�����
		}
		return rs;
	}

}
