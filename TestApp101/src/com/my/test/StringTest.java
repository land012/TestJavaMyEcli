package com.my.test;

import java.io.UnsupportedEncodingException;

import com.my.base.BaseTest;

public class StringTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String str1 = "abcde";
//		if(str1.length()>4) {
//			str1 = str1.substring(str1.length()-4);
//		}
//		info.info(str1);
		
		// �滻 �� ������ʽ
//		String str1 = "abacad";
//		info.info(str1.replace("a", "x"));
//		info.info(str1.replaceAll("a", "x"));
//		String[] arr1 = str1.split("a");
//		for(String s : arr1) {
//			info.info(s);
//		}
		
//		// ��ӡ null
//		String str1 = null;
//		info.info(str1); // ""
//		info.info(str1 + ""); // null
//		System.out.println(str1); // null
//		String str2 = str1 + "";
//		if("null".equals(str2)) {
//			info.info("str2 �� \"null\"������ null��");
//		} else {
//			info.info("str2 �� null");
//		}
		
//		// �ַ������ֽ�����
//		String str1 = "abc";
//		byte[] arr1 = str1.getBytes();
//		for(byte b : arr1) {
//			info.info(b + " - 0x" + Integer.toString(b, 16));
//		}
		
//		// ����תΪ�ֽ���
//		String str2 = "����";
//		byte[] arr2;
//		try {
//			arr2 = str2.getBytes("gbk");
//			for(byte b : arr2) {
//				info.info(b);
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		// split ���ָ��������ǿ�ʱ���õ������ݳ���
//		String str1 = "k1=";
//		String[] arr1 = str1.split("=");
//		System.out.println(arr1.length); // 1
//		String str1 = null;
//		String[] arr1 = str1.split("_");
//		System.out.println(arr1.length);
//		for(int i=0; i<arr1.length; i++) {
//			System.out.println("arr1[" + i + "]=" + arr1[i]);
//		}
		
//		StringBuffer strb = new StringBuffer();
//		if(null == strb.toString()) {
//			System.out.println("null");
//		} else if("".equals(strb.toString())) {
//			System.out.println("��");
//		} else {
//			System.out.println("����");
//		}
		
//		String str1 = "abcdef";
//		System.out.println(str1.substring(1, str1.indexOf("c")));
		
//		// startWith // ���ִ�Сд
//		String str1 = "abc";
//		String str2 = "";
//		String str3 = " ";
//		System.out.println(str1.startsWith("ab"));
//		System.out.println(str1.toUpperCase().startsWith("A")); // true
//		System.out.println(str1.startsWith(""));  // true
//		
//		System.out.println(str2.startsWith(""));  // true
//		
//		System.out.println(str3.startsWith(""));  // true
//		System.out.println(str3.startsWith(" ")); // true
//		System.out.println(str3.startsWith("a")); // false
		
//		// ��Сдת��
//		System.out.println("���".toUpperCase()); // ���
//		
//		/**
//		 * compareTo() �Ƚ�
//		 * ���ǰ��� Unicode С�� ���棬���� ���������򷵻�����
//		 */
//		System.out.println("a".compareTo("b")); // -1
//		System.out.println("b".compareTo("a")); // 1
////		
////		"abc".getBytes();
//		
//		System.out.println("��".compareTo("��"));
		
//		/**
//		 * ȡ�Ӵ�
//		 * ��Ŵ� 0 ��ʼ��������������������ַ�
//		 */
//		System.out.println("abcd".substring(2, 3)); // c
		
//		String str1 = "abc";
//		String str2 = str1.intern();
//		System.out.println(str1 == str2); // true
//		
//		String str3 = new String("abc");
//		String str4 = str3;
//		System.out.println(str3 == str4); //true
//		str3 = "bcd";
//		System.out.println(str3 == str4); // false
//		System.out.println(str4);         // "abc"
//		
//		String str5 = "abc";
//		String str6 = "abc";
//		String str7 = new String("abc");
//		System.out.println(str5==str6);    // true
//		System.out.println(str5==str7);    // false
//		System.out.println(str6 == "abc"); // true 
		
		System.out.format("%s%n", "1".equals(1));   // false
		System.out.format("%s%n", "1".equals("1")); // true
	}

}
