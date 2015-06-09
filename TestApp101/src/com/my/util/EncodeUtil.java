package com.my.util;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {
	/**
	 * ��ȡ�ַ��� str ָ���ַ�����ʮ�����Ʊ���
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
