package com.umbrella.concurrent.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
		/**
		 * 如果 MyTask 成员变量在声明时被赋值，那么在第二次执行 MyTask时，成员变量仍是第一次执行时的值
		 * 因为只有一个 MyTask 对象
		 */
		ses.scheduleAtFixedRate(new MyTask(), 0, 3000, TimeUnit.MILLISECONDS);
	}

}
