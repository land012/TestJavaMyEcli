package com.umbrella.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class HelloServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -539243038282974116L;
	
	private static Logger log = Logger.getLogger(HelloServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.info("this is HelloServlet doGet " + this);
//		resp.getWriter().write("Hello Servlet!");
		Cookie cookie = new Cookie("ck_k1", "ck_v1");
		cookie.setMaxAge(10 * 60);
		cookie.setPath("/");
		resp.addCookie(cookie);
		req.getRequestDispatcher("pages/helloservlet.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
	
	/**
	 * 只执行一次
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		log.info("this is HelloServlet init");
	}

}
