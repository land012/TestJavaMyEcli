package com.umbrella.designpattern.masterworker;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public abstract class Worker implements Runnable {
	
	private static Logger log = Logger.getLogger(Worker.class);
	
	private Queue<Object> taskQueue;
	private Map<Object, Object> resultMap;
	private AtomicInteger commitCount;
	
	public void setTaskQueue(Queue<Object> queue) {
		this.taskQueue = queue;
	}
	
	public void setResultMap(Map<Object, Object> map) {
		this.resultMap = map;
	}
	
	public void setCommitCount(AtomicInteger count) {
		this.commitCount = count;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(this.taskQueue) {
				while(taskQueue.isEmpty()) {
					log.info("任务队列是空，等待...");
					try {
						taskQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
//			for(Object task; (task=taskQueue.poll())!=null; ) {
//				log.info("处理任务：" + task);
//				Object res = this.handle(task);
//				this.resultMap.put(task, res);
//				this.commitCount.incrementAndGet();
//			}
			Object task = taskQueue.poll();
			log.info("从队列中获取任务：" + task);
			if(task!=null) {
				log.info("处理任务：" + task);
				Object res = this.handle(task);
				this.resultMap.put(task, res);
				this.commitCount.incrementAndGet();
			}
		}
	}
	
	protected abstract Object handle(Object task);

}
