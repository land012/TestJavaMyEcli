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
	 * 获取文件的扩展名
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
	 * 获取当前时间的字符串 yyyyMMddHHmmss
	 * @return
	 */
	public static String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(Calendar.getInstance().getTime());
	}
	
	/**
	 * 对字符串进行转码
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
	
	// 默认转码
	public static String convertEncode(String str) throws UnsupportedEncodingException {
		return convertEncode(str, "ISO-8859-1", "gbk");
	}
	
	public static void response(HttpServletResponse response, String contentType, String content) {
		System.out.println("响应内容：" + content);
		
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
