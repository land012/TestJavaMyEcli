package com.land.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
/**
 * 这个Servlet 做为接口，被小程序调用
 * @author asdf
 *
 */
public class WaitServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(WaitServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取参数
		String k1 = req.getParameter("k1");
		String k2 = req.getParameter("k2");
		log.info("k1=" + k1 + "|k2=" + k2);
		
		log.info("request.getPathInfo()=" + req.getPathInfo());       // /w
		log.info("request.getServletPath()=" + req.getServletPath()); // /wait
		
		log.info("req.getHeader(\"referer\")=" + req.getHeader("referer"));
		
		log.info("打印 Header ==============================");
		
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			log.info(name + "=" + req.getHeader(name));
		}
		
		log.info("打印 Header ==============================");
		
		
		StringBuffer sbIn = new StringBuffer();
		
		// 获取参数2
		BufferedInputStream bis = new BufferedInputStream(req.getInputStream());
		int i;
		byte[] bufIn = new byte[1024];
		while((i=bis.read(bufIn)) != -1) {
			sbIn.append(new String(bufIn, 0, i, "gbk"));
		}
		
		// 获取参数3
//		BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream(), "gbk"));
//		String line = "";
//		while((line=br.readLine())!= null) {
//			sbIn.append(line);
//		}
		
		if(sbIn!=null && sbIn.length()>0) {
			log.info(URLDecoder.decode(sbIn.toString(), "gbk"));
		} else {
			log.info("输入流中没有数据！");
		}
		
		// 响应
//		resp.setContentType("text/plain; charset=gbk");
		resp.setContentType("text/html; charset=gbk");
//		resp.setCharacterEncoding("gbk");
		PrintWriter pw = resp.getWriter();
//		pw.write("<?xml version=\"1.0\" encoding=\"gbk\"?>\n<msg>I'm waiting!</msg>");
		pw.write("request.getRequestURL():" + req.getRequestURL() + "<br/>");
		pw.write("request.getRequestURI():" + req.getRequestURI() + "<br/>");
		pw.write("request.getContextPath():" + req.getContextPath() + "<br/>");
		pw.write("request.getServletPath():" + req.getServletPath() + "<br/>");
		pw.write("request.getPathInfo():" + req.getPathInfo() + "<br/>");
		pw.write("request.getQueryString():" + req.getQueryString() + "<br/>");
		pw.write("request.getProtocol():" + req.getProtocol() + "<br/>");
		
		pw.write("======================================<br/>");
		
		pw.write("request.getLocalAddr():" + req.getLocalAddr() + "<br/>");
		pw.write("request.getLocalName():" + req.getLocalName() + "<br/>");
		pw.write("request.getLocalPort():" + req.getLocalPort() + "<br/>");
		
		pw.write("======================================<br/>");
		
		pw.write("request.getRemoteAddr():" + req.getRemoteAddr() + "<br/>");
		pw.write("request.getRemoteHost():" + req.getRemoteHost() + "<br/>");
		pw.write("request.getRemotePort():" + req.getRemotePort() + "<br/>");
//		pw.flush();
//		pw.close();
		
		req.setAttribute("name", "小王");
		//req.getRequestDispatcher("/pages/waitservlet.jsp").forward(req, resp);
	}

}
