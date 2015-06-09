package com.my.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.my.base.BaseTest;
import com.my.util.HttpUtils;
/**
 * 测试调用Web中的接口
 * @author asdf
 *
 */
public class URLTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		doPost();
		
		String url = "http://localhost:9999/web1/wait_wait2.do";
		String params = null;
		try {
//			params = "k1=" + java.net.URLEncoder.encode("你好", "utf-8") +
//				"&k2=" + java.net.URLEncoder.encode("小李", "utf-8");
			params = "k1=" + java.net.URLEncoder.encode("你好", "gbk") +
			"&k2=" + java.net.URLEncoder.encode("小李", "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 * 用 POST 方式提交，不必进行编码
		 * 如果进行了编码，服务器端无法得到正确的结果
		 */
//		params = "k1=你好&k2=小李";
		
		System.out.println("请求参数：" + params);
//		String res = HttpUtils.doPost(url, params, "utf-8");
		String res = HttpUtils.doGet(url + "?" + params, "iso-8859-1");
		try {
			System.out.println("响应，转码前：" + res);
			
			System.out.println("响应，转码前：" + new String(res.getBytes("iso8859-1"), "gbk"));
			
			System.out.println("响应，转码后：" + java.net.URLDecoder.decode(res, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
//		String url1 = "http://api.yzch.net:998/sale.ashx";
//		try {
//			URL reqUrl1 = new URL(url1);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
	}

}
