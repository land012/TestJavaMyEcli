package com.umbrella.produconsu2;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public abstract class Producer<T> implements Runnable {
	
	private static Logger log = Logger.getLogger(Producer.class);
	
	private BlockingQueue<T> queue;

	@Override
	public void run() {
		List<T> list = produce();
		if(list != null) {
			for(T t : list) {
				try {
					queue.put(t);
					log.info(Thread.currentThread().getName() + " Éú²ú " + t);
				} catch (InterruptedException e) {
					log.info("", e);
				}
			}
		}
	}
	
	public abstract List<T> produce();
	
	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}

}
