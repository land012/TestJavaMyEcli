package com.umbrella.threadlocal;

import org.apache.log4j.Logger;

public class Step2 {
	private static Logger log = Logger.getLogger(Step2.class);
	
	public void exe() {
		// ��ȡ ThreadLocalMap �еĸ����̵߳� user
		User u = UserUtil.getUser();
		log.info(u + ",name=" + u.getName());
	}
}
