package com.my.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorldThread implements Runnable {

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() + " sleep!");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + " wake!");
		System.out.println("Hello World Thread! " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
	}

}
