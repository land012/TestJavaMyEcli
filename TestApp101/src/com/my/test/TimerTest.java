package com.my.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.my.base.BaseTest;

public class TimerTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt) + "（程序启动时刻）");
		
		TimerTask r1 = new TimerTask() {
			public void run() {
				DateTime dt = new DateTime();
				info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt) + " task begin");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
				double j = 2;
				for(long i=0; i<2000000000L; i++) {
					j = j * j;
					if(j>1000000) j = 2;
				}
				
				DateTime dt2 = new DateTime();
				info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt2) + " task end");
			}
		};
		
		Timer timer = new Timer();
		
		/*
		 * 定时执行任务
		 * 指定延时执行
		 */
//		timer.schedule(r1, 2000L);
		
		/*
		 * 首次在指定延时后执行
		 * 之后按指定固定周期执行
		 * 当 task本身执行时间较长时(大于指定周期)，那么执行的周期就没有意义，下次执行的开始时间为 上次任务执行的结束时间
		 */
//		timer.schedule(r1, 1000, 3000);
		
		/*
		 * 首次在指定延时后执行
		 * 之后按指定固定周期执行
		 */
		timer.scheduleAtFixedRate(r1, 1000, 3000);
		
	}

}
