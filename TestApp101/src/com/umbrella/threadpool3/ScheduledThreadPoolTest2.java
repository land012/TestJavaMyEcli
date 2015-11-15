package com.umbrella.threadpool3;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.umbrella.threadpool3.Task;
/**
 * 
 * @author asdf
 *
 */
public class ScheduledThreadPoolTest2 {
	
	private static final Logger log = Logger.getLogger(ScheduledThreadPoolTest2.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * �̳߳��������������߳�
		 */
		ScheduledThreadPoolExecutor exec2 = new ScheduledThreadPoolExecutor(2);
		
		/*
		 * ���������������ʹ���̳߳��е�ĳ�������߳�
		 */
		exec2.scheduleAtFixedRate(new Task(), 1000, 2000, TimeUnit.MILLISECONDS);
		exec2.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				log.info(Thread.currentThread().getName() + " 2");
			}
			
		}, 1000, 2000, TimeUnit.MILLISECONDS);
	}

}
