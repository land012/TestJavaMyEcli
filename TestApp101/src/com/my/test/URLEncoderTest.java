package com.my.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import org.apache.commons.lang3.StringEscapeUtils;

import com.my.base.BaseTest;
import com.my.util.EncodeUtil;

public class URLEncoderTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URLEncoder.encode("", "gbk");
			/*
			 * 将特殊字符编码为 %十六进制表示
			 */
//			info.info(URLEncoder.encode("http://localhost:index.jsp?k1=v1&k2=汉字", "utf-8"));
			
//			System.out.println(URLEncoder.encode("我", "utf-8"));  // %E6%88%91
//			System.out.println(URLEncoder.encode("我", "gbk"));    // %CE%D2
//			System.out.println(URLDecoder.decode("%E6%88%91", "gbk"));   // 鎴?
//			System.out.println(URLDecoder.decode("%E6%88%91", "utf-8")); // 我
//			System.out.println("===================");
//			System.out.println(URLEncoder.encode("我", "ISO-8859-1"));           // %3F
//			System.out.println(new String("%3F".getBytes("ISO-8859-1"), "gbk")); // %3F
//			System.out.println(new String("我".getBytes("ISO-8859-1"), "ISO-8859-1")); // ?
//			System.out.println(new String(new String("我".getBytes("gbk"), "ISO-8859-1").getBytes("ISO-8859-1"),
//					"GBK")); // 我
			
			// 不影响，正常返回汉字
//			System.out.println(URLDecoder.decode("我", "utf-8"));
			
//			System.out.println("============= utf-8 =============");
//			System.out.println(URLEncoder.encode("A", "utf-8"));
//			byte[] byte0 = "A".getBytes("utf-8");
//			System.out.println(Arrays.toString(byte0)); // [65]
//			
//			System.out.println("============= utf-8 =============");
//			System.out.println(URLEncoder.encode("我", "utf-8")); // %E6%88%91
//			byte[] byte1 = "我".getBytes("utf-8");
//			System.out.println(Arrays.toString(byte1)); // [-26, -120, -111]
//			System.out.println(new String(byte1, "utf-8")); //我
//			
//			System.out.println("============= iso-8859-1 =============");
//			System.out.println(URLEncoder.encode("我", "iso-8859-1")); // %3F
//			byte[] byte3 = "我".getBytes("iso-8859-1");
//			System.out.println(Arrays.toString(byte3)); // [63]
//			System.out.println(new String(byte1, "utf-8")); // 我
//			
//			System.out.println("============= gbk =============");
//			System.out.println(URLEncoder.encode("我", "gbk")); // %CE%D2
//			byte[] byte2 = "我".getBytes("gbk"); // 数组长度为2
//			System.out.println(Arrays.toString(byte2));
			
//			String str1 = URLEncoder.encode("我", "utf-8");
//			byte[] byte4 = str1.getBytes("ISO-8859-1");
//			System.out.println(Arrays.toString(byte4)); // [37, 69, 54, 37, 56, 56, 37, 57, 49]
//			System.out.println(new String(byte4, "utf-8")); // %E6%88%91
//			System.out.println(URLDecoder.decode(new String(byte4, "utf-8"), "utf-8")); //我 
			
//			String str1 = "你好";
//			str1 = URLEncoder.encode(str1, "utf-8");
//			System.out.println(str1);
//			str1 = URLEncoder.encode(str1, "utf-8");
//			System.out.println(str1);
//			str1 = URLDecoder.decode(str1, "iso-8859-1");
//			System.out.println(str1);
//			str1 = URLDecoder.decode(str1, "utf-8");
//			System.out.println(str1);
			
//			String str2 = "你好吗";
//			str2 = URLEncoder.encode(str2, "utf-8");
//			System.out.println(str2);
//			str2 = URLDecoder.decode(str2, "iso-8859-1"); // 这一步是服务器端自动解析的
//			System.out.println(str2);
//			str2 = URLEncoder.encode(str2, "iso-8859-1");
//			System.out.println(str2);
//			str2 = URLDecoder.decode(str2, "utf-8");
//			System.out.println(str2);
			
//			// %3F 就是 ？
//			System.out.println(URLDecoder.decode("%3F", "utf-8"));
//			System.out.println(URLDecoder.decode("%3F", "iso-8859-1"));
//			System.out.println(URLDecoder.decode("%3F", "gbk"));
//			System.out.println(URLDecoder.decode("%E5%88%3F", "utf-8")); // ??
//			
//			System.out.println(URLDecoder.decode("%E5%88%34", "utf-8")); //
//			System.out.println(URLDecoder.decode("%34", "utf-8")); //
			
			// iso-8859-1 不能处理汉字
//			String str11 = URLEncoder.encode("我", "iso-8859-1");
//			System.out.println(str11);
//			System.out.println(URLDecoder.decode(str11, "iso-8859-1"));
			
			// java.lang.NullPointerException
//			System.out.println(URLEncoder.encode(null, "gbk"));
			
//			// 用3字节表示
//			System.out.println(URLEncoder.encode("你好", "utf-8"));
//			// 不进制编码
//			System.out.println(URLEncoder.encode("A", "utf-8"));
			
//			System.out.println(URLEncoder.encode("好", "gbk"));     // %BA%C3
//			System.out.println(URLEncoder.encode("好", "gb18030")); // %BA%C3
//			System.out.println(URLEncoder.encode("好", "utf-8"));   // %E5%A5%BD
//			System.out.println(URLEncoder.encode("好", "utf-16"));  // %FE%FF%59%7D
//			System.out.println(URLEncoder.encode("好", "utf-32"));  // %00%00%59%7D
//			System.out.println(URLEncoder.encode("好", "unicode")); // %FE%FF%59%7D
			
//			/**
//			 * 手动计算编码
//			 */
//			String str1 = "a";
//			byte[] arr1 = str1.getBytes("gbk");
//			System.out.print(str1 + ":");
//			for(byte b : arr1) {
//				System.out.print(b);
//			}
//			System.out.println();
//			System.out.println("-----------------");
			
//			/**
//			 * 手动计算编码
//			 */
//			String str2 = "好";
//			byte[] arr2 = str2.getBytes("gbk");
//			System.out.print(str2 + ":");
//			for(byte b : arr2) {
//				System.out.print(Integer.toHexString(b & 0xff));
//			}
//			System.out.println();
//			for(byte b : arr2) {
//				System.out.print(Integer.toHexString(b) + "|");
//			}
//			System.out.println();
//			for(byte b : arr2) {
//				System.out.print(Integer.toBinaryString(b) + "|");
//			}
//			
//			System.out.println();
//			System.out.println("-----------------");
//			
//			System.out.println("===== " + str2 + " gbk: =====");
//			System.out.println(URLEncoder.encode(str2, "gbk"));         // %BA%C3
//			System.out.println(EncodeUtil.getEncodeStr(str2, "gbk"));   // 0xbac3
//			System.out.println(StringEscapeUtils.escapeJava(str2));     // \u597D
//			System.out.println("===== " + str2 + " utf-8: =====");
//			System.out.println(URLEncoder.encode(str2, "utf-8"));       // %E5%A5%BD
//			System.out.println(EncodeUtil.getEncodeStr(str2, "utf-8")); // 0xe5a5bd
			
//			System.out.println(URLEncoder.encode("赵钱钱", "utf-8"));
//			System.out.println(URLEncoder.encode("赵 钱钱", "utf-8"));
//			System.out.println(URLEncoder.encode("赵钱钱", "gbk"));
//			System.out.println(URLEncoder.encode("赵钱钱", "gbk"));
			
			
			String str1 = "赵 钱+钱";
			String str2 = URLEncoder.encode(str1, "gbk");
			String str3 = URLDecoder.decode(str2, "gbk");
			String str4 = URLDecoder.decode(str3, "gbk");
			
			System.out.println("str1=" + str1);
			/*
			 * 第一次转码时
			 * 空格" " - "+"号
			 * "+"号       - "%2B"
			 */
			System.out.println("str2=" + str2);
			System.out.println(str3);
			System.out.println(str4); // 第二次解码时会出问题
			
			String str5 = URLEncoder.encode(URLEncoder.encode(str1, "gbk"), "gbk");
			String str6 = URLDecoder.decode(str5, "gbk");
			String str7 = URLDecoder.decode(str6, "gbk");
			System.out.println("str5=" + str5);
			System.out.println("str6=" + str6);
			System.out.println("str7=" + str7);
			
			/*
			 * str2 使用 gbk 编码过
			 * 第一次解码，使用 “ISO-8859-1”(模拟get方式提交，tomcat自动转码)
			 * 必然乱码
			 */
			// 
			String str8 = URLDecoder.decode(str2, "ISO-8859-1");
			// 再次使用 gbk，对已经出错的解码结果进行解码，必然乱码
			String str9 = URLDecoder.decode(str8, "gbk");
			System.out.println("str8=" + str8);
			System.out.println("str9=" + str9);
			
			String str10 = new String(str8.getBytes("ISO-8859-1"), "gbk");
			String str11 = URLDecoder.decode(URLEncoder.encode(str8, "ISO-8859-1"), "gbk");
			System.out.println("str10=" + str10);
			System.out.println("str11=" + str11);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
