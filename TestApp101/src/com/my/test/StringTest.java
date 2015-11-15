package com.my.test;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;

import com.my.base.BaseTest;

public class StringTest extends BaseTest {
	private static final int TIMES = 100000;
	
	@Before
	public void before() {
		
	}
	
	/**
	 * String
	 */
	@Test
	public void test1() {
		String temp = "abcdefghijklmnopqrstuvwxyz"; // String Constant Pool
		long start1 = System.currentTimeMillis();
		String str1 = "";
		for(int i=0; i<TIMES; i++) {
			str1 += temp;
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 1322
	}
	
	/**
	 * StringBuilder
	 */
	@Test
	public void test2() {
		String temp = "abcdefghijklmnopqrstuvwxyz";
		long start1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<TIMES; i++) {
			sb1.append(temp);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}
	
	@Test
	public void test3() {
		long start1 = System.currentTimeMillis();
		StringBuilder sb1 = new StringBuilder();
		for(int i=0; i<TIMES; i++) {
			sb1.append("abcdefghijklmnopqrstuvwxyz"); // String Constant Pool
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}
	
	/**
	 * StringBuffer
	 */
	@Test
	public void test4() {
		String temp = "abcdefghijklmnopqrstuvwxyz";
		long start1 = System.currentTimeMillis();
		StringBuffer sb1 = new StringBuffer();
		for(int i=0; i<TIMES; i++) {
			sb1.append(temp);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1); // 30~40
	}

	/**
	 * @param args
	 */
	public void test100() {
//		String str1 = "abcde";
//		if(str1.length()>4) {
//			str1 = str1.substring(str1.length()-4);
//		}
//		info.info(str1);
		
		// 替换 与 正则表达式
//		String str1 = "abacad";
//		info.info(str1.replace("a", "x"));
//		info.info(str1.replaceAll("a", "x"));
//		String[] arr1 = str1.split("a");
//		for(String s : arr1) {
//			info.info(s);
//		}
		
//		// 打印 null
//		String str1 = null;
//		info.info(str1); // ""
//		info.info(str1 + ""); // null
//		System.out.println(str1); // null
//		String str2 = str1 + "";
//		if("null".equals(str2)) {
//			info.info("str2 是 \"null\"，不是 null！");
//		} else {
//			info.info("str2 是 null");
//		}
		
//		// 字符串的字节数组
//		String str1 = "abc";
//		byte[] arr1 = str1.getBytes();
//		for(byte b : arr1) {
//			info.info(b + " - 0x" + Integer.toString(b, 16));
//		}
		
//		// 汉字转为字节码
//		String str2 = "我你";
//		byte[] arr2;
//		try {
//			arr2 = str2.getBytes("gbk");
//			for(byte b : arr2) {
//				info.info(b);
//			}
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
		
		// split 当分隔符后面是空时，得到的数据长度
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
//			System.out.println("空");
//		} else {
//			System.out.println("其他");
//		}
		
//		String str1 = "abcdef";
//		System.out.println(str1.substring(1, str1.indexOf("c")));
		
//		// startWith // 区分大小写
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
		
//		// 大小写转换
//		System.out.println("你好".toUpperCase()); // 你好
//		
//		/**
//		 * compareTo() 比较
//		 * 如果前面的 Unicode 小于 后面，返回 负数；否则返回正数
//		 */
//		System.out.println("a".compareTo("b")); // -1
//		System.out.println("b".compareTo("a")); // 1
////		
////		"abc".getBytes();
//		
//		System.out.println("征".compareTo("搜"));
		
//		/**
//		 * 取子串
//		 * 序号从 0 开始，不包括结束序号所在字符
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
	
	@Test
	public void test160() {
//		String str1 = "ghcynkflhni8fq8g3ll6zajyyxcf4wjrn651zj47ads3g8imvtrvf9t7vitx0vh5ahsigvdcwu929aqdpso2gwmtj8vhlgredqmrcifp2i19gvbkibetc86xx7ag8jk5";
//		System.out.println(str1.length());
		
		// 取子串
//		String str2 = "abcd";
//		System.out.println(StringUtils.substring(str2, 1, str2.length()));
//		
//		System.out.println(StringUtils.indexOf("abcd", "a")); // 0
//		
//		// 直接打印日期
//		System.out.println(new Date());
		
//		// 字符串用 == 比较
//		System.out.println("abc" == "abc"); // true
//		System.out.println("abc" == ("ab" + "c")); // true
//		String str3 = "abc";
//		String str4 = "abc";
//		String str5 = "ab" + "c";
//		System.out.println(str3 == str4); // true
//		System.out.println(str3 == str5); // true
		
		/**
		 * 判断字符串是否相等 ==
		 */
//		String str6 = "a";
//		String str7 = "b";
//		String str8 = "ab";
//		String str9 = "a" + "b";
//		String str10 = str6 + "b";
//		String str11 = "a" + str7;
//		String str12 = str6 + str7;
//		String str13 = new String("ab");
//		System.out.println(str8 == str9);  // true
//		System.out.println(str8 == str10); // false
//		System.out.println(str8 == str11); // false
//		System.out.println(str8 == str12); // false
//		System.out.println(str8 == str13); // false
//		
//		String str14 = str13.intern();
//		System.out.println(str14 == str8);  // true
//		System.out.println(str14 == str13); // false
//		
//		String str15 = str8.intern();
//		System.out.println(str15 == str8);  // true
//		
//		String str16 = str8;
//		System.out.println(str16 == str8);  // true
//		
//		String str17 = new String(new char[]{'a', 'b'});
//		System.out.println(str17 == str8);  // false
		
		String str1 = new String(new char[10]);
		System.out.println("str1=" + str1 + "|");
		System.out.println("str1.length()=" + str1.length());
	}
	
	@Test
	public void test210() {
		String str1 = "亲亲袋鼠-VINCI";
		System.out.println(str1.length()); // 10
	}

}
