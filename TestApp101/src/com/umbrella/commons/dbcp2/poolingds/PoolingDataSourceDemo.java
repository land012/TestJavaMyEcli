package com.umbrella.commons.dbcp2.poolingds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 数据源池
 * @author asdf
 * 这种情况需要关闭 Connection，否则程序执行到第9次时，就卡住了
 */
public class PoolingDataSourceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SystemConfig.init();
		
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.scheduleAtFixedRate(new MyTask(SystemConfig.getDataSource("test"), "select * from user t where t.id>13 order by t.id desc"), 0, 3000, TimeUnit.MILLISECONDS);
		ses.scheduleAtFixedRate(new MyTask(SystemConfig.getDataSource("diskmgmt"), "select * from disk t where t.id = 1"), 0, 3000, TimeUnit.MILLISECONDS);
	}
}
