package com.umbrella.commons.dbcp2.poolingdriver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author asdf
 * 执行到第9个的时候，程序就卡住了，那是因为没有关闭 Connnection
 * 但写了 conn.close()后，代码会在这一步卡住
 */
public class PoolingDriverDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DBPool().init();
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.scheduleAtFixedRate(new MyTask(), 0, 2000, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(new MyTask(), 0, 2000, TimeUnit.MILLISECONDS);
		
//		new Thread(new MyTask()).start();
	}

}
