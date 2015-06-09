package com.land.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

public class CommonUtils {
	
	/**
	 * ��ȡ�ļ�����չ��
	 * @param fileName
	 * @return
	 */
	public static String getExtName(String fileName) {
		String extName = "";
		if(StringUtils.isNotEmpty(fileName)) {
			int index = StringUtils.lastIndexOf(fileName, ".");
			if(index!=-1) {
				extName = StringUtils.substring(fileName, index + 1);
			}
		}
		return extName;
	}
	
	/**
	 * ��ȡ��ǰʱ����ַ��� yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * ���ַ�������ת��
	 * @param str
	 * @param srcCode
	 * @param descCode
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String convertEncode(String str, String srcCode, String descCode) throws UnsupportedEncodingException {
		if(StringUtils.isNotEmpty(str)) {
			return new String(str.getBytes(srcCode), descCode);
		}
		return null;
	}
	
	// Ĭ��ת��
	public static String convertEncode(String str) throws UnsupportedEncodingException {
		return convertEncode(str, "ISO-8859-1", "gbk");
	}
	
	public static void response(HttpServletResponse response, String contentType, String content) {
		System.out.println("��Ӧ���ݣ�" + content);
		
		response.setContentType(contentType);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(content);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != pw) {
				pw.close();
				pw = null;
			}
		}
	}
}
