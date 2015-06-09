package com.umbrella.concurrent.scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class MyTask implements Runnable {
	
	private static Logger log = Logger.getLogger(MyTask.class);
	
	private Date date = new Date();
	
	public MyTask() {
		super();
		log.info("i am MyTask!");
	}

	@Override
	public void run() {
		log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
