package com.umbrella.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

public class MyTask extends TimerTask {
	
	private static final Logger log = Logger.getLogger(MyTask.class);
	
	private Calendar cal = Calendar.getInstance();
	
	public MyTask() {
		super();
		log.info("i am mytask");
	}

	@Override
	public void run() {
		log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()));
		log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
