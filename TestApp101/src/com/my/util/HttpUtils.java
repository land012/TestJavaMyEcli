package com.my.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtils {
	
	/**
	 * doGet
	 * @param url
	 * @return
	 */
	public static String doGet(String url, String charset) {
		URL reqUrl = null;
		URLConnection conn = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			reqUrl = new URL(url);
			conn = reqUrl.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(false);
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while((line=in.readLine())!=null) {
				result.append(line);
			}
			
//			InputStream is = conn.getInputStream();
//			byte[] buf = new byte[1024];
//			int i = -1;
//			while((i=is.read(buf))!=-1) {
//				result.append(new String(buf, 0, i));
//			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
		}
		return result.toString();
	} // doGet()
	
	/**
	 * doPost
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, String params, String charset) {
		URL reqUrl = null;
		URLConnection conn = null;
		OutputStreamWriter out = null;
		BufferedWriter bw = null;
		OutputStream os = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try {
			reqUrl = new URL(url);
			conn = reqUrl.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
//			conn.setRequestProperty("accept-charset", charset);
			
//			out = new OutputStreamWriter(conn.getOutputStream(), charset);
//			out.write(params);
//			out.flush();
			
//			os = conn.getOutputStream();
//			byte[] paramsbyte = params.getBytes(charset);
//			os.write(paramsbyte);
//			os.flush();
			
//			bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), charset));
			bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			bw.write(params);
			bw.flush();
			
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			String line = null;
			while((line=in.readLine())!=null) {
				result.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out = null;
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
		}
		return result.toString();
	} // doPost()
	
	/**
	 * 使用 POST 方式提交
	 */
	public static void doPost2() {
		String interfurl = ""; // 接口地址
		String params = "";
		URL httpUrl = null;
		HttpURLConnection conn = null;
		BufferedOutputStream bos = null;
		OutputStreamWriter osw   = null;
		BufferedInputStream bis  = null;
		BufferedReader br        = null;
		try {
//			interfurl     = "http://localhost:9999/WaitServlet.do";
			
			interfurl     = "http://localhost:9999/wait_wait1.do";
//			params  = "k1=" + URLEncoder.encode("你好", "gbk") + "&k2=" + URLEncoder.encode("小王", "gbk");
			params  = "k1=你好&k2=小王";
//			params  = "我发起请求了！";
			httpUrl  = new URL(interfurl);
			conn = (HttpURLConnection)httpUrl.openConnection();
//			conn.connect();
			conn.setReadTimeout(3000);
			conn.setConnectTimeout(3000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("charset", "gbk");
			// 传递流，当不设置 content-type时，servlet 中可以使用 request.getParameter("k1") 获取参数
//			conn.setRequestProperty("content-type", "text/html");
//			conn.setRequestProperty("content-type", "multipart/form-data");
			// 使用下面的设置，servlet 中可以使用 request.getParameter("k1") 获取参数
			conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			
			// 输出字节流
			bos = new BufferedOutputStream(conn.getOutputStream());
			byte[] bufOut = params.getBytes();
			bos.write(bufOut);
			bos.flush();
			bos.close();
			
			// 输出字符流
//			osw = new OutputStreamWriter(urlConn.getOutputStream());
//			osw.write(params);
//			osw.flush();
//			osw.close();
			
			StringBuffer isb = new StringBuffer();
			// 从字节流读取
			bis = new BufferedInputStream(conn.getInputStream());
			byte[] buf = new byte[1024];
			int i = -1;
			while((i = bis.read(buf)) != -1) {
				isb.append(new String(buf, 0, i, "gbk"));
			}
			// 从字符流读取
//			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "gbk"));
//			String line = "";
//			while((line = br.readLine()) != null) {
//				isb.append(line);
//			}
			
			System.out.println("响应内容：" + isb.toString());
		} catch (UnsupportedEncodingException e) {
			System.out.println("编码异常！");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			System.out.println("创建URL！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("连接异常！");
			e.printStackTrace();
		} finally {
			if(bos!=null) {
				try {
					bos.close();
					bos = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(bis!=null) {
				try {
					bis.close();
					bis = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				conn.disconnect();
				conn = null;
			}
		}
	}  // doPost2()
}
