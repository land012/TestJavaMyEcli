package com.land.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class DemoFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(DemoFilter.class);
	
	private FilterConfig cfg;

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		log.info("DemoFilter begin ...");
		log.info("k1=" + cfg.getInitParameter("k1"));
		chain.doFilter(req, resp);
		log.info("DemoFilter end ...");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("DemoFilter 初始化");
		this.cfg = filterConfig;
	}
	
	@Override
	public void destroy() {
		log.info("DemoFilter 销毁了");
	}

}
