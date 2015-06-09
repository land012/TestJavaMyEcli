package com.land.action;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.land.base.BaseAction;

public class WaitAction extends BaseAction {
	
	private static Logger log = Logger.getLogger(WaitAction.class);
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7650044224575270302L;

	public String wait1() {
		// 获取参数
		String k1 = request.getParameter("k1");
		String k2 = request.getParameter("k2");
		System.out.println("request.getParameter:" + k1 + "|" + k2);
		
		BufferedInputStream bis = null;
		try {
			bis = new BufferedInputStream(request.getInputStream());
			byte[] bufIn = new byte[1024];
			int i = -1;
			StringBuffer sbIn = new StringBuffer();
			while((i = bis.read(bufIn)) != -1) {
				sbIn.append(new String(bufIn, 0, i, "gbk"));
			}
			System.out.println("request.getInputStream:" + sbIn.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 响应
//		resp.setContentType("text/plain; charset=gbk");
		response.setCharacterEncoding("gbk");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write("<?xml version=\"1.0\" encoding=\"gbk\"?>\n<msg>I'm waiting!</msg>");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(pw != null) {
				pw.close();
				pw = null;
			}
		}
		
		return null;
	}
	
	public String wait2() {
		try {
			System.out.println("提交方式=" + request.getMethod());
			System.out.println("queryString:" + request.getQueryString());
			
			request.setCharacterEncoding("utf-8");
			String k1 = StringUtils.trimToEmpty(request.getParameter("k1"));
			String k2 = request.getParameter("k2");
			info.info("k1转码前：" + k1);
			info.info("k2转码前：" + k2);
			
			// POST
			System.out.println("================= POST ==================");
			info.info("k1转码后(utf-8)：" + URLDecoder.decode(new String(k1.getBytes("ISO-8859-1"), "utf-8"), "utf-8") );
			info.info("k1转码后(utf-8)：" + URLDecoder.decode(k1, "utf-8"));
			info.info("k1转码后(gbk)：" + URLDecoder.decode(new String(k1.getBytes("ISO-8859-1"), "utf-8"), "gbk") );
			info.info("k1转码后(gbk)：" + URLDecoder.decode(k1, "gbk"));
			
			// GET 直接提交汉字时的转码方式
			System.out.println("================= GET ==================");
//			info.info("转码后：" + new String(k1.getBytes("ISO-8859-1"), "gbk"));
			
			// GET 提交时用 utf-8编码 ，直接转码
			info.info("直接转码(utf-8)：k1=" + URLDecoder.decode(k1, "utf-8"));
			
			// GET 将汉字转码后提交
			String k1_gbk = new String(k1.getBytes("ISO-8859-1"), "gbk");
			info.info("k1转码(gbk):" + k1_gbk);
			
			String k1_utf8 = new String(k1.getBytes("ISO-8859-1"), "utf-8");
			info.info("k1转码(utf-8):" + k1_utf8);
			info.info("k1转码后(utf-8)：" + URLDecoder.decode(k1_utf8, "utf-8"));
			
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		
		// 去掉这句，客户端接收到的汉字乱码
//		response.setContentType("text/html; charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		PrintWriter pw;
		String outStr = null;
		try {
			pw = response.getWriter();
//			outStr = "k1=" + java.net.URLEncoder.encode("你也好", "utf-8");
			outStr = "k1=你好呀";
			System.out.println(response.getCharacterEncoding());
			System.out.println(response.getContentType());
			pw.write(outStr);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String wait3() {
		log.info("this is wait3");
		try {
			response.getWriter().write("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

