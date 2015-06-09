package com.umbrella.produconsu2;

import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

public abstract class Consumer<T> implements Runnable {
	
	private static Logger log = Logger.getLogger(Producer.class);
	
	private BlockingQueue<T> queue;

	@Override
	public void run() {
		try {
			T t = queue.take();
			consume(t);
		} catch (InterruptedException e) {
			log.info("", e);
		}
	}
	
	public abstract void consume(T t);
	
	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}

}
