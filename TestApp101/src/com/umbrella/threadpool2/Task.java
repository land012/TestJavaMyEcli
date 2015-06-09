package com.umbrella.threadpool2;

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * 任务
 * @author asdf
 *
 * @param <T>
 */
public abstract class Task implements Runnable {
	
	private static final Logger log = Logger.getLogger(Task.class);
	
	private Date generateTime;
	private Date submitTime;
	private Date execBeginTime;
	private Date execEndTime;
	private long taskId;
	
	public Task() {
		this.generateTime = new Date();
	}

	@Override
	public void run() {
		log.info("i am Task-");
		try {
			Thread.sleep(3000);
			exec();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public abstract boolean exec();
	
	/**
	 * 是否立即执行
	 * @return
	 */
	public abstract boolean isExecuteImmediate();
	
	/**
	 * 任务信息
	 * @return
	 */
	public abstract String info();

	public Date getGenerateTime() {
		return generateTime;
	}

	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Date getExecBeginTime() {
		return execBeginTime;
	}

	public void setExecBeginTime(Date execBeginTime) {
		this.execBeginTime = execBeginTime;
	}

	public Date getExecEndTime() {
		return execEndTime;
	}

	public void setExecEndTime(Date execEndTime) {
		this.execEndTime = execEndTime;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

}
