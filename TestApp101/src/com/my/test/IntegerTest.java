package com.my.test;

import com.my.base.BaseTest;

public class IntegerTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "123.3";
//		// �쳣 java.lang.NumberFormatException
//		int i1 = Integer.parseInt(str1);
		
//		String str2 = "10.0";
//		// �쳣 java.lang.NumberFormatException
//		int i2 = Integer.parseInt(str2);
		
//		String str3 = "124";
//		int i3 = Integer.parseInt(str3);
//		
//		int ip1 = 1;
//		double dp2 = 1.0;
//		if(ip1<=dp2) {
//			info.info("С�ڵ���");
//		}
		
//		String str4 = null;
//		// �쳣 java.lang.NumberFormatException: null
//		Integer.parseInt(str4);
		
//		String str5 = "";
//		// �쳣 java.lang.NumberFormatException: For input string: ""
//		Integer.parseInt(str5);
		
//		System.out.println(new Integer("").intValue()); //  java.lang.NumberFormatException
		
//		/*
//		 * ������ǿ��ת��Ϊ����
//		 */
//		double d1 = 5.0;
//		int i1 = 2;
//		int i2 = (int)d1/i1;
//		
//		double d3 = 5.9;
//		int i3 = (int)d3;
////		System.out.println(i3); // 5
		
		/**
		 * instanceof
		 */
//		Integer i4 = new Integer(2);
		
		// ������� Syntax error on token "int",Dimensions expected after this token
//		System.out.println(i3 instanceof int);
		
		// ������� Incompatible conditional operand types int and int[]
//		System.out.println(i3 instanceof int[]);
		
//		System.out.println(i4 instanceof Integer); // true
		
		String str1 = "1";
//		 // ������� Incompatible conditional operand types String and Integer
//		System.out.println(str1 instanceof Integer);
		
		// ����ת��
		int i1 = 0x82003;
		log.info(i1);
		log.info(Integer.toHexString(532483));
		log.info(Integer.toHexString(8519683)); //0x820003
	}

}
