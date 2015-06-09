package com.xyz.util;

public class StringUtil {
	public static String getRandomNum(int length) {
		String res = "";
		for(int i=0; i<length; i++) {
			double d1 = Math.random() * 10;
			String str = String.valueOf(d1);
			res += str.substring(0, 1);
		}
		return res;
	}
}
