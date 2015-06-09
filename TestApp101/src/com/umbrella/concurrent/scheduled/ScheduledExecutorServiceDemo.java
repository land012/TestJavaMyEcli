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
		 * ��� MyTask ��Ա����������ʱ����ֵ����ô�ڵڶ���ִ�� MyTaskʱ����Ա�������ǵ�һ��ִ��ʱ��ֵ
		 * ��Ϊֻ��һ�� MyTask ����
		 */
		ses.scheduleAtFixedRate(new MyTask(), 0, 3000, TimeUnit.MILLISECONDS);
	}

}
