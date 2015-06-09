package com.my.test1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.TimeUnit;
/**
 * 线程池 ScheduledExecutorService
 * @author xudz
 *
 */
public class T4 {
	
	public static void main(String[] args) {
		
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		final Runnable r1 = new Runnable(){
			public void run() {
				/*
				 * 当 sdf 不使用final 时，提示编译错误 
				 * Cannot refer to a non-final variable sdf inside an inner class defined in a different method
				 */ 
				System.out.println("AtFixedRate：" + sdf.format(new Date()));
				m1();
			}
			public void m1() {
				System.out.println("invoke m1!");
			}
		};
		final Runnable r2 = new Runnable(){
			public void run() {
				System.out.println("WiFixedDely：" + sdf.format(new Date()));
			}
		};
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.scheduleAtFixedRate(r1, 0, 2493, TimeUnit.MILLISECONDS);
		ses.scheduleWithFixedDelay(r2, 0, 2493, TimeUnit.MILLISECONDS);
	}
}