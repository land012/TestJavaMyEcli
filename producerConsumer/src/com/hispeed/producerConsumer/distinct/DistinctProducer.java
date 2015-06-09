package com.hispeed.producerConsumer.distinct;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.hispeed.producerConsumer.util.LRULinkedHashMap;

/**
 * 
 * 不包含去重功能的生产者-消费者模式 生产者抽象类
 * @author liyong
 */

public abstract class DistinctProducer<T> implements Runnable {
	
	private static final Logger alert = Logger.getLogger("alert");
	private static final Logger msg = Logger.getLogger("thread");
	private static final Logger err = Logger.getLogger("thread_error");
	
	private String producerid;
	private BlockingQueue<T> queue;
	
	//处理中的资源列表
	private ConcurrentHashMap<String,Long> dealingmap;
	//处理成功的资源列表
	private LRULinkedHashMap<String, Long> succmap;
	
	private long noProductIdletimes;
	private long hasProductIdletimes;
	
	private long succtimeProtecttimes;
	public final void run() {
		try{
			while(!Thread.interrupted()){
				//获取队列
				List<T> list = getProducts();
				
				if(list!=null&&list.size()>0){
					Long currentTime = System.currentTimeMillis();
					//将所查到的list全部放到队列中
					msg.debug("生产者"+producerid+" 已获得资源list size="+list.size());
					for(T t:list){	
						//获取资源的主键id及当前时间，调用ConcurrentHashMap的putIfAbsent方法，如果返回值与当前时间不一致，表示之前已存在该资源，则放弃该资源
						String objectKeyId = getObjectKeyId(t);
						Long puttime = dealingmap.putIfAbsent(objectKeyId,currentTime);
						if(puttime!=null){
							//返回值不相等，表示之前已存在该资源，则放弃该资源
							msg.debug("资源"+objectKeyId+"正在处理中,放弃该资源并继续循环 puttime="+puttime+" currentTime="+currentTime);
							continue;
						}
						Long succtime = succmap.get(objectKeyId);
						if(succtime!=null){
							//如果存在于成功队列，则比较时间,如果获取资源的时间小于等于成功的时间，说明该信息已过去，则舍弃,如果获取资源的时间大于成功的时间，则表示资源需要发送
							if(currentTime<=succtime+succtimeProtecttimes){
								msg.debug("资源"+objectKeyId+"已成功,放弃该资源并继续循环 succtime="+succtime+" currentTime="+currentTime);
								//删除dealingmap中的缓存
								dealingmap.remove(objectKeyId);
								continue;
							}else{
								succmap.remove(objectKeyId);
								msg.info("资源"+objectKeyId+"已成功,但获取资源的时间大于成功的时间,需要再次发送 succtime="+succtime+" currentTime="+currentTime);
							}
						}
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


	public void setDealingmap(ConcurrentHashMap<String, Long> dealingmap) {
		this.dealingmap = dealingmap;
	}


	public void setNoProductIdletimes(long noProductIdletimes) {
		this.noProductIdletimes = noProductIdletimes;
	}
	
	public void setSuccmap(LRULinkedHashMap<String, Long> succmap) {
		this.succmap = succmap;
	}


	public void setHasProductIdletimes(long hasProductIdletimes) {
		this.hasProductIdletimes = hasProductIdletimes;
	}

	public void setSucctimeProtecttimes(long succtimeProtecttimes) {
		this.succtimeProtecttimes = succtimeProtecttimes;
	}

}
