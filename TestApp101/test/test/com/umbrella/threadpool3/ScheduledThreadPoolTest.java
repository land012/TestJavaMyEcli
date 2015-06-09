package test.com.umbrella.threadpool3;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.umbrella.threadpool3.Task;
/**
 * 
 * @author asdf
 *
 */
public class ScheduledThreadPoolTest {
	
	private static final Logger log = Logger.getLogger(ScheduledThreadPoolTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * �̳߳���ֻ��һ�������߳�
		 */
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		
		/*
		 * ������������ʹ���̳߳��е�ͬһ�������߳�
		 */
		exec.scheduleAtFixedRate(new Task(), 1000, 2000, TimeUnit.MILLISECONDS);
	}

}
