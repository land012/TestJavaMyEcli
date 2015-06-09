package com.umbrella.produconsu2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Ö´ÐÐÕß
 * @author asdf
 *
 * @param <T>
 */
public class PCExecutors<T> {
	public void execute(String producerName, String consumerName, int queueSize) {
		try {
			ScheduledExecutorService exec = Executors.newScheduledThreadPool(6);
			
			BlockingQueue<T> queue = new ArrayBlockingQueue<T>(queueSize); 
			
			for(int i=0; i<3; i++) {
	//			Class clazz = Class.forName(producerName);
	//			Producer<T> p = (Producer)clazz.getConstructor(new Class[0]).newInstance(new Object[0]);
				Producer<T> p = (Producer)Class.forName(producerName).newInstance();
				
				p.setQueue(queue);
				exec.scheduleAtFixedRate(p, 0, 60 * 1000, TimeUnit.MILLISECONDS);
			}
			for(int i=0; i<3; i++) {
				Consumer<T> c = (Consumer)Class.forName(consumerName).newInstance();
				c.setQueue(queue);
				exec.scheduleAtFixedRate(c, 0, 3 * 1000, TimeUnit.MILLISECONDS);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
