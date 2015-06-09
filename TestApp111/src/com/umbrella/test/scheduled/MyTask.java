package com.umbrella.test.scheduled;

import org.apache.log4j.Logger;
/**
 * 
 * @author asdf
 *
 */
public class MyTask implements Runnable {
	
	private static Logger log = Logger.getLogger(MyTask.class);

	@Override
	public void run() {
		log.info("begin");
		log.info("end");
	}

}
