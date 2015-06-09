package com.umbrella.designpattern.masterworker;

//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.log4j.Logger;

public class Master {
	
	private static Logger log = Logger.getLogger(Master.class);
	
//	private List<Thread> lists;            // 工作线程队列
	private Queue<Object> taskQueue;       // 任务队列
	private Map<Object, Object> resultMap; // 处理结果集
	private AtomicInteger taskCount;       // 当前任务总数
	private AtomicInteger commitCount;     // 当前任务完成数
	
	public Master(Worker worker, int workerCount) {
//		lists = new ArrayList<Thread>();
		taskQueue = new ConcurrentLinkedQueue<Object>();
		resultMap = new ConcurrentHashMap<Object, Object>();
		this.taskCount = new AtomicInteger();
		this.commitCount = new AtomicInteger();
		worker.setTaskQueue(taskQueue);
		worker.setResultMap(resultMap);
		worker.setCommitCount(commitCount);
		for(int i=1; i<=workerCount; i++) {
//			lists.add(new Thread(worker));
			new Thread(worker).start();
		}
	}
	
	public void addTask(Object task) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(this.taskQueue) {
			log.info("添加任务：" + task);
			this.taskQueue.add(task);
			this.taskCount.incrementAndGet();
			taskQueue.notifyAll();
		}
	}
	
//	public void process() {
//		for(Thread t : this.lists) {
//			t.start();
//		}
//	}
	
	public Map<Object, Object> getResultMap() {
		return this.resultMap;
	}
	
	public boolean isComplete() {
		return (this.taskCount.get() == this.commitCount.get()) && this.resultMap.isEmpty();
	}
}
