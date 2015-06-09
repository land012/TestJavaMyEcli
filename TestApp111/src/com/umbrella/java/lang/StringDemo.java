package com.umbrella.java.lang;

import java.util.Date;

import javax.print.attribute.standard.MediaSize.Other;

import org.apache.commons.lang3.StringUtils;

public class StringDemo {

	public static void main(String[] args) {
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

}
