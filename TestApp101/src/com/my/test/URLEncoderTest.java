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
			 * �������ַ�����Ϊ %ʮ�����Ʊ�ʾ
			 */
//			info.info(URLEncoder.encode("http://localhost:index.jsp?k1=v1&k2=����", "utf-8"));
			
//			System.out.println(URLEncoder.encode("��", "utf-8"));  // %E6%88%91
//			System.out.println(URLEncoder.encode("��", "gbk"));    // %CE%D2
//			System.out.println(URLDecoder.decode("%E6%88%91", "gbk"));   // �?
//			System.out.println(URLDecoder.decode("%E6%88%91", "utf-8")); // ��
//			System.out.println("===================");
//			System.out.println(URLEncoder.encode("��", "ISO-8859-1"));           // %3F
//			System.out.println(new String("%3F".getBytes("ISO-8859-1"), "gbk")); // %3F
//			System.out.println(new String("��".getBytes("ISO-8859-1"), "ISO-8859-1")); // ?
//			System.out.println(new String(new String("��".getBytes("gbk"), "ISO-8859-1").getBytes("ISO-8859-1"),
//					"GBK")); // ��
			
			// ��Ӱ�죬�������غ���
//			System.out.println(URLDecoder.decode("��", "utf-8"));
			
//			System.out.println("============= utf-8 =============");
//			System.out.println(URLEncoder.encode("A", "utf-8"));
//			byte[] byte0 = "A".getBytes("utf-8");
//			System.out.println(Arrays.toString(byte0)); // [65]
//			
//			System.out.println("============= utf-8 =============");
//			System.out.println(URLEncoder.encode("��", "utf-8")); // %E6%88%91
//			byte[] byte1 = "��".getBytes("utf-8");
//			System.out.println(Arrays.toString(byte1)); // [-26, -120, -111]
//			System.out.println(new String(byte1, "utf-8")); //��
//			
//			System.out.println("============= iso-8859-1 =============");
//			System.out.println(URLEncoder.encode("��", "iso-8859-1")); // %3F
//			byte[] byte3 = "��".getBytes("iso-8859-1");
//			System.out.println(Arrays.toString(byte3)); // [63]
//			System.out.println(new String(byte1, "utf-8")); // ��
//			
//			System.out.println("============= gbk =============");
//			System.out.println(URLEncoder.encode("��", "gbk")); // %CE%D2
//			byte[] byte2 = "��".getBytes("gbk"); // ���鳤��Ϊ2
//			System.out.println(Arrays.toString(byte2));
			
//			String str1 = URLEncoder.encode("��", "utf-8");
//			byte[] byte4 = str1.getBytes("ISO-8859-1");
//			System.out.println(Arrays.toString(byte4)); // [37, 69, 54, 37, 56, 56, 37, 57, 49]
//			System.out.println(new String(byte4, "utf-8")); // %E6%88%91
//			System.out.println(URLDecoder.decode(new String(byte4, "utf-8"), "utf-8")); //�� 
			
//			String str1 = "���";
//			str1 = URLEncoder.encode(str1, "utf-8");
//			System.out.println(str1);
//			str1 = URLEncoder.encode(str1, "utf-8");
//			System.out.println(str1);
//			str1 = URLDecoder.decode(str1, "iso-8859-1");
//			System.out.println(str1);
//			str1 = URLDecoder.decode(str1, "utf-8");
//			System.out.println(str1);
			
//			String str2 = "�����";
//			str2 = URLEncoder.encode(str2, "utf-8");
//			System.out.println(str2);
//			str2 = URLDecoder.decode(str2, "iso-8859-1"); // ��һ���Ƿ��������Զ�������
//			System.out.println(str2);
//			str2 = URLEncoder.encode(str2, "iso-8859-1");
//			System.out.println(str2);
//			str2 = URLDecoder.decode(str2, "utf-8");
//			System.out.println(str2);
			
//			// %3F ���� ��
//			System.out.println(URLDecoder.decode("%3F", "utf-8"));
//			System.out.println(URLDecoder.decode("%3F", "iso-8859-1"));
//			System.out.println(URLDecoder.decode("%3F", "gbk"));
//			System.out.println(URLDecoder.decode("%E5%88%3F", "utf-8")); // ??
//			
//			System.out.println(URLDecoder.decode("%E5%88%34", "utf-8")); //
//			System.out.println(URLDecoder.decode("%34", "utf-8")); //
			
			// iso-8859-1 ���ܴ�����
//			String str11 = URLEncoder.encode("��", "iso-8859-1");
//			System.out.println(str11);
//			System.out.println(URLDecoder.decode(str11, "iso-8859-1"));
			
			// java.lang.NullPointerException
//			System.out.println(URLEncoder.encode(null, "gbk"));
			
//			// ��3�ֽڱ�ʾ
//			System.out.println(URLEncoder.encode("���", "utf-8"));
//			// �����Ʊ���
//			System.out.println(URLEncoder.encode("A", "utf-8"));
			
//			System.out.println(URLEncoder.encode("��", "gbk"));     // %BA%C3
//			System.out.println(URLEncoder.encode("��", "gb18030")); // %BA%C3
//			System.out.println(URLEncoder.encode("��", "utf-8"));   // %E5%A5%BD
//			System.out.println(URLEncoder.encode("��", "utf-16"));  // %FE%FF%59%7D
//			System.out.println(URLEncoder.encode("��", "utf-32"));  // %00%00%59%7D
//			System.out.println(URLEncoder.encode("��", "unicode")); // %FE%FF%59%7D
			
//			/**
//			 * �ֶ��������
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
//			 * �ֶ��������
//			 */
//			String str2 = "��";
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
			
//			System.out.println(URLEncoder.encode("��ǮǮ", "utf-8"));
//			System.out.println(URLEncoder.encode("�� ǮǮ", "utf-8"));
//			System.out.println(URLEncoder.encode("��ǮǮ", "gbk"));
//			System.out.println(URLEncoder.encode("��ǮǮ", "gbk"));
			
			
			String str1 = "�� Ǯ+Ǯ";
			String str2 = URLEncoder.encode(str1, "gbk");
			String str3 = URLDecoder.decode(str2, "gbk");
			String str4 = URLDecoder.decode(str3, "gbk");
			
			System.out.println("str1=" + str1);
			/*
			 * ��һ��ת��ʱ
			 * �ո�" " - "+"��
			 * "+"��       - "%2B"
			 */
			System.out.println("str2=" + str2);
			System.out.println(str3);
			System.out.println(str4); // �ڶ��ν���ʱ�������
			
			String str5 = URLEncoder.encode(URLEncoder.encode(str1, "gbk"), "gbk");
			String str6 = URLDecoder.decode(str5, "gbk");
			String str7 = URLDecoder.decode(str6, "gbk");
			System.out.println("str5=" + str5);
			System.out.println("str6=" + str6);
			System.out.println("str7=" + str7);
			
			/*
			 * str2 ʹ�� gbk �����
			 * ��һ�ν��룬ʹ�� ��ISO-8859-1��(ģ��get��ʽ�ύ��tomcat�Զ�ת��)
			 * ��Ȼ����
			 */
			// 
			String str8 = URLDecoder.decode(str2, "ISO-8859-1");
			// �ٴ�ʹ�� gbk�����Ѿ�����Ľ��������н��룬��Ȼ����
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
