package com.umbrella.commons.dbcp2.poolingdriver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author asdf
 * ִ�е���9����ʱ�򣬳���Ϳ�ס�ˣ�������Ϊû�йر� Connnection
 * ��д�� conn.close()�󣬴��������һ����ס
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
