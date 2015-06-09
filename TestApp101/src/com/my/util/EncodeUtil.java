package com.my.util;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {
	/**
	 * 获取字符串 str 指定字符集的十六进制编码
	 * @param str
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String getEncodeStr(String str, String charset) throws UnsupportedEncodingException {
		StringBuffer res = new StringBuffer();
		byte[] arr = str.getBytes(charset);
		for(byte b : arr) {
			String hex = Integer.toHexString(b & 0xff);
			res.append(hex);
		}
		
		return "0x" + res.toString();
	}
}
