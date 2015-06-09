package com.hispeed.producerConsumer.nodistinct;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * 
 * 不包含去重功能的生产者-消费者模式 生产者抽象类
 * @author liyong
 */

public abstract class NoDistinctProducer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String producerid;
	private BlockingQueue<T> queue;
	private long noProductIdletimes;
	private long hasProductIdletimes;
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//获取队列
				List<T> list = getProducts();
				
				if(list!=null&&list.size()>0){
					//将所查到的list全部放到队列中
					msg.debug("生产者"+producerid+" 已获得资源list size="+list.size());
					for(T t:list){
						queue.put(t);
						msg.debug("生产者"+producerid+" 将资源"+getObjectKeyId(t)+"放入队列");
					}
					msg.debug("生产者"+producerid+"放入队列完毕,休眠"+hasProductIdletimes+"毫秒");
					Thread.sleep(hasProductIdletimes);
				}else{
					msg.debug("生产者"+producerid+" 没有获得资源list,休眠"+noProductIdletimes+"毫秒");
					Thread.sleep(noProductIdletimes);
				}
			}
		}catch (Exception e) {
			err.info("",e);
		}

	}
	

	//获取资源list抽象方法
	public abstract List<T> getProducts();
	public abstract String getObjectKeyId(T t);


	public void setProducerid(String producerid) {
		this.producerid = producerid;
	}


	public void setQueue(BlockingQueue<T> queue) {
		this.queue = queue;
	}


	public void setNoProductIdletimes(long noProductIdletimes) {
		this.noProductIdletimes = noProductIdletimes;
	}
	
	public void setHasProductIdletimes(long hasProductIdletimes) {
		this.hasProductIdletimes = hasProductIdletimes;
	}
}
