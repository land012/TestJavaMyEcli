package com.umbrella.threadpool;

import org.apache.log4j.Logger;

public class Task implements Runnable {
	
	private static Logger log = Logger.getLogger(Task.class);
	private static int i = 0;

	@Override
	public void run() {
		User u =  new User();
		u.setId(i);
		u.setName("tom" + i);
		log.info("I am " + Thread.currentThread().getName() + ",user=" + i);
		i++;
	}

}
