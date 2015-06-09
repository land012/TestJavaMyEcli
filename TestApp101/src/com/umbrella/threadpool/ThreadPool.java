package com.umbrella.threadpool;

import java.util.LinkedList;

import org.apache.log4j.Logger;

/**
 * 线程池
 * @author asdf
 * 继承 ThreadGroup 的方式创建线程池
 *
 */
public class ThreadPool extends ThreadGroup {
	
	private static final Logger log = Logger.getLogger(ThreadPool.class);
	
	private boolean isClose = false;
	private LinkedList<Runnable> workQueue;
	private static String threadPoolID = "1";
	
	/**
	 * 创建线程池，并启动工作线程
	 * @param threadID
	 * @return
	 * @throws InterruptedException
	 */
	public ThreadPool(int poolSize) {
		super(threadPoolID);
		this.setDaemon(true);
		this.workQueue = new LinkedList<Runnable>(); // 任务队列
		for(int i=0; i<poolSize; i++) {
			new WorkThread(String.valueOf(i)).start();
		}
	}
	
	/**
	 * 工作线程获取队列中的任务
	 * @param threadID
	 * @return
	 * @throws InterruptedException
	 */
	public synchronized Runnable getTask(String threadID) throws InterruptedException {
		while(this.workQueue.size() == 0) {
			if(this.isClose) {
				log.info("工作线程 " + threadID + ", ThreadPool 已经 close");
				return null;
			}
			log.info("工作线程 " + threadID + " 等待任务...");
			this.wait(); // 调用该方法的线程进入 wait 状态
		}
		log.info("工作线程 " + threadID + " 开始执行任务...");
		return this.workQueue.removeFirst();
	}
	
	/**
	 * 执行新任务
	 * @param task
	 */
	public synchronized void execute(Runnable task) {
		if(isClose) {
			throw new IllegalStateException("线程池已关闭！");
		}
		if(task != null) {
			this.workQueue.add(task);
			this.notify(); // 唤醒线程池中处于 wait 状态的线程
		}
	}
	
	public synchronized void closePool() {
		log.info("closePool - step-1");
		
		if(!this.isClose) {
			log.info("closePool - step-2"); // 这里不会被执行到,waitFinish() 中已经 isClose=true 了
			this.waitFinish();
			this.isClose = true;
			this.workQueue.clear();
			this.interrupt();
		}
	}
	
	public void waitFinish() {
		log.info("waitFinish");
		
		synchronized(this) {
			this.isClose = true;
			/*
			 * 如果不加这一句
			 * 当某些工作线程进入 wait状态后，无法被唤醒，导致程序无法结束
			 */
			this.notifyAll();
		}
		
//		Thread[] threads = new Thread[this.activeCount()];
//		int count = this.enumerate(threads);
//		
//		log.info("当前处于活动状态的工作线程数=" + count);
//		
//		for(int i=0; i<count; i++) {
//			try {
//				threads[i].join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	/**
	 * 工作线程
	 * @author asdf
	 *
	 */
	private class WorkThread extends Thread {
		private String threadID; // 当前工作线程 name
		
		public WorkThread(String threadID) {
			super(ThreadPool.this, threadID);
			this.threadID = threadID;
		}

		@Override
		public void run() {
			while(!this.isInterrupted()) {
				Runnable task = null;
				try {
					task = getTask(this.threadID);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(task == null) return;
				task.run(); // 在当前工作线程中运行任务
			}
		}
	}
}
