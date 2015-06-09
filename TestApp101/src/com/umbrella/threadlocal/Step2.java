package com.umbrella.threadlocal;

import org.apache.log4j.Logger;

public class Step2 {
	private static Logger log = Logger.getLogger(Step2.class);
	
	public void exe() {
		// 获取 ThreadLocalMap 中的各自线程的 user
		User u = UserUtil.getUser();
		log.info(u + ",name=" + u.getName());
	}
}
