package com.umbrella.threadpool2;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * 线程池
 * @author asdf
 * 自定义线程池
 *
 */
public final class ThreadPool {
	private static final Logger log = Logger.getLogger(ThreadPool.class);
	
	private int workerNum = 5;
	private static int taskCounter = 0;
	private static List<Task> taskQueue = Collections.synchronizedList(new LinkedList<Task>());
	private Worker[] workers;
	
	public ThreadPool(int workerNum) {
		this.workerNum = workerNum;
		workers = new Worker[workerNum];
		for(int i=0; i<workerNum; i++) {
			workers[i] = new Worker(i);
			workers[i].start();
		}
	}
	
	public void addTask(Task task) {
		synchronized(taskQueue) {
			task.setTaskId(++taskCounter);
			task.setSubmitTime(new Date());
			taskQueue.add(task);
			taskQueue.notifyAll();
		}
	}
	
	public void waitFinish() {
		log.info("waitFinish()");
		for(int i=0; i<this.workerNum; i++) {
			try {
				workers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void destory() {
//		waitFinish();
		
		for(int i=0; i<this.workerNum; i++) {
			workers[i].stopWork();
			workers[i] = null;
		}
		taskQueue.clear();
		log.info("pool is destory!");
	}
	
	private class Worker extends Thread {
		private int index = -1;
		private boolean isRunning = true;
		private boolean isWaiting = true;
		
		public Worker(int index) {
			this.index = index;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public boolean isWaiting() {
			return this.isWaiting;
		}
		
		public void stopWork() {
			this.isRunning = false;
		}

		@Override
		public void run() {
			log.info("Worker-" + this.getIndex() + " run()");
			while(this.isRunning) {
				log.info("Worker-" + this.getIndex() + " isRunning=" + this.isRunning);
				Task r = null;
				synchronized(taskQueue) {
					while(taskQueue.isEmpty()) {
						log.info("taskQueue is Empty, Worker-" + this.getIndex() + (this.isWaiting() ? " Waiting" : " Working"));
						try {
							taskQueue.wait(2000);
						} catch (InterruptedException e) {
							log.info("", e);
						}
					}
					r = taskQueue.remove(0);
				}
				
				if(r != null) {
					this.isWaiting = false;
					
					r.setExecBeginTime(new Date());
					log.info("task-" + r.getTaskId() + " waiting time(ms)=" + (r.getExecBeginTime().getTime()-r.getSubmitTime().getTime()));
					
					if(r.isExecuteImmediate()) {
						new Thread(r).start();
					} else {
						r.run();
					}
					
					r.setExecEndTime(new Date());
					log.info("task-" + r.getTaskId() + " execute time(ms)=" + (r.getExecEndTime().getTime()-r.getExecBeginTime().getTime()));
				}
				this.isWaiting = true;
				r = null;
			}
		}
	}
}
