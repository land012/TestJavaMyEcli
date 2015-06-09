package com.hispeed.producerConsumer.distinct;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.hispeed.producerConsumer.util.LRULinkedHashMap;

/**
 * 
 * 不包含去重功能的生产者-消费者模式 消费者抽象类
 * @author liyong
 */

public abstract class DistinctConsumer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String consumerid;
	private BlockingQueue<T> queue;
	//处理中的资源列表
	private ConcurrentHashMap<String,Long> dealingmap;
	//待重发的资源列表
	private BlockingQueue<T> reofferqueue;
	//处理成功的资源列表
	private LRULinkedHashMap<String, Long> succmap;
	
	private boolean isNeedReOffer;//发送失败是否需要从新插入队列标识
	
	
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//从队列中获取资源，并从队列移除该资源
				T t = queue.take();
				
				msg.debug("消费者"+consumerid+"获取到待消费资源"+getObjectKeyId(t));
				boolean consumeresult = false;
				try{
					consumeresult = consume(t);
				}catch (Exception e) {
					err.info("",e);
				}
				if(consumeresult){
					//如果消费成功，则完成,添加到已成功队列，并从已存在的资源列表中删除
					succmap.put(getObjectKeyId(t), System.currentTimeMillis());
					dealingmap.remove(getObjectKeyId(t));
					msg.debug("消费者"+consumerid+"完成"+getObjectKeyId(t)+"消费");
				}else{
					//消费不成功时
					if(isNeedReOffer){
						//需要重新插入队列标识时，则重新加入队列等待处理
						//此处不采取阻塞等待方式，因为可能产生死锁，所以新增加一个需要重新offer的Map,该Map由另一线程负责reoffer
						reofferqueue.put(t);
						err.debug("消费者"+consumerid+"未完成"+getObjectKeyId(t)+"消费,将资源放入reoffer队列");
						
					}else{
						//不需要重新插入队列标识时，从存在的资源列表中删除
						dealingmap.remove(getObjectKeyId(t));
						err.debug("消费者"+consumerid+"未完成"+getObjectKeyId(t)+"消费,从存在的资源列表中删除");
					}
					
				}
			}
		}catch (Exception e) {
			err.info("",e);
		}

	}
	
	
	//消费抽象方法
	public abstract boolean consume(T t);
	
	public abstract String getObjectKeyId(T t);
	
	
	
	


	public void setConsumerid(String consumerid) {
		this.consumerid = consumerid;
	}

	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}


	public void setDealingmap(ConcurrentHashMap<String, Long> dealingmap) {
		this.dealingmap = dealingmap;
	}

	public void setReofferqueue(BlockingQueue<T> reofferqueue) {
		this.reofferqueue = reofferqueue;
	}


	public void setNeedReOffer(boolean isNeedReOffer) {
		this.isNeedReOffer = isNeedReOffer;
	}


	public void setSuccmap(LRULinkedHashMap<String, Long> succmap) {
		this.succmap = succmap;
	}

}
