package com.umbrella.java.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class DecoderDemo {

	public static void main(String[] args) {
		try {
			String str1 = URLDecoder.decode("%25", "utf-8");
			System.out.println(str1);
			String str2 = URLEncoder.encode("%", "utf-8");
			System.out.println(str2);
			
			System.out.println("=======================================");
			
			String str3 = URLDecoder.decode("%23%3d", "utf-8");
			System.out.println("%23%3d" + " " + str3);
			
			// ¿Õ×Ö·û
			System.out.println("=======================================");
			String str4 = " ";
			System.out.println(str4 + "=" + URLEncoder.encode(str4 , "utf-8"));
			System.out.println("=======================================");
			String str5 = "\r";
			System.out.println(str5 + "=" + URLEncoder.encode(str5 , "utf-8"));
			System.out.println("=======================================");
			String str6 = "\n";
			System.out.println(str6 + "=" + URLEncoder.encode(str6 , "utf-8"));
			System.out.println("=======================================");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
