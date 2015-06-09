package com.hispeed.producerConsumer;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * 
 * 不包含去重功能的生产者-消费者模式 消费者抽象类
 * @author liyong
 */

public class ReOfferResourceThread<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	

	private BlockingQueue<T> queue;

	//待重发的资源列表
	private BlockingQueue<T> reofferqueue;

	
	public ReOfferResourceThread(BlockingQueue<T> queue,BlockingQueue<T> reofferqueue){
		this.queue = queue;
		this.reofferqueue = reofferqueue;
	}
	
	
	public final void run() {
		try{
			while(!Thread.interrupted()){
				
				T t = reofferqueue.take();
				msg.info("ReOfferResourceThread获取到将资源");
				queue.put(t);
				msg.info("ReOfferResourceThread将资源放入队列");
			}
		}catch (Exception e) {
			err.info("",e);
		}

	}


}
