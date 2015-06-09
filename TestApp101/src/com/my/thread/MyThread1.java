package com.my.thread;

import org.apache.log4j.Logger;

public class MyThread1 extends Thread {
	
	private static Logger log = Logger.getLogger(MyThread1.class);

	@Override
	public void run() {
		log.info("mythread1 begin!");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("mythread1 end!");
	}

}
