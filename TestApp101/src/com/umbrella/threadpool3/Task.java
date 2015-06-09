package com.umbrella.threadpool3;

import org.apache.log4j.Logger;

/**
 * 
 * @author asdf
 * JDK自带线程池 ExecutorService
 *
 */
public class Task implements Runnable {
	
	private static final Logger log = Logger.getLogger(Task.class);

	@Override
	public void run() {
		log.info(Thread.currentThread().getName() + " is Running");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
