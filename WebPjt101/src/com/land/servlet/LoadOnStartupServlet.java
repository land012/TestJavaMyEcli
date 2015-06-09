package com.land.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.land.util.Config;

public class LoadOnStartupServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ������ servlet��ʼ��ʱ���ᱻ���ص�
		String abpath = req.getSession().getServletContext().getRealPath("");
		
		System.out.println("this is loadonstartupservlet.doPost");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("LoadOnStartupServlet load!");
		
		// ��ʼ������
		System.out.println("k1=" + this.getInitParameter("k1")); // v1
		System.out.println("k2=" + this.getInitParameter("k2")); // v2
		
		String path1 = this.getServletContext().getContextPath(); // �����ļ�·��
		String path2 = this.getServletContext().getRealPath("/"); // D:\_c_myEc9\WebPjt1\WebRoot\
		String path3 = this.getServletContext().getRealPath("");  // D:\_c_myEc9\WebPjt1\WebRoot
		System.out.println("path1=" + path1);
		System.out.println("path2=" + path2);
		System.out.println("path2=" + path3);
		
		// ��ȡ�����ļ�
//		String classpath = this.getClass().getClassLoader().getResource("/").getPath();
//		int endindex = classpath.lastIndexOf("WEB-INF");
//		String abspath = classpath.substring(1, endindex);
		String abspath = path2;
//		System.out.println("classpath=" + classpath);
		System.out.println("abspath=" + abspath);
		try {
			Config.getProperties(new FileInputStream(abspath + "ini/config.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("�����ļ��� k1=" + Config.getProperty("k1"));
	}
}
