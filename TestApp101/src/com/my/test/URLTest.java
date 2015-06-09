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
 * ���Ե���Web�еĽӿ�
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
//			params = "k1=" + java.net.URLEncoder.encode("���", "utf-8") +
//				"&k2=" + java.net.URLEncoder.encode("С��", "utf-8");
			params = "k1=" + java.net.URLEncoder.encode("���", "gbk") +
			"&k2=" + java.net.URLEncoder.encode("С��", "gbk");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		/*
		 * �� POST ��ʽ�ύ�����ؽ��б���
		 * ��������˱��룬���������޷��õ���ȷ�Ľ��
		 */
//		params = "k1=���&k2=С��";
		
		System.out.println("���������" + params);
//		String res = HttpUtils.doPost(url, params, "utf-8");
		String res = HttpUtils.doGet(url + "?" + params, "iso-8859-1");
		try {
			System.out.println("��Ӧ��ת��ǰ��" + res);
			
			System.out.println("��Ӧ��ת��ǰ��" + new String(res.getBytes("iso8859-1"), "gbk"));
			
			System.out.println("��Ӧ��ת���" + java.net.URLDecoder.decode(res, "utf-8"));
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
