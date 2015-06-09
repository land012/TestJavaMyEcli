package com.umbrella.test.gc;

import org.apache.log4j.Logger;

import com.umbrella.vo.User;

public class Demo {
	
	private static Logger log = Logger.getLogger(Demo.class);

	public static void main(String[] args) {
		log.info("begin");
		User u1 = new User();
		u1.getId();
		u1 = null;
		System.gc();
		
		try {
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("end");
		
	}

}
