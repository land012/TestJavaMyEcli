package com.umbrella.designpattern.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.apache.log4j.Logger;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				Data data = new RealData();
				doOtherTasks();
				doDataTask(data);
				log.info("普通写法耗时：" + (System.currentTimeMillis() - s) + "ms");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				FutureTask<Data> futureTask = new FutureTask<Data>(new Callable<Data>() {
					@Override
					public Data call() throws Exception {
						return new RealData();
					}
				});
				ExecutorService exec = Executors.newFixedThreadPool(1);
				exec.submit(futureTask);
				exec.shutdown();
				doOtherTasks();
				try {
					doDataTask(futureTask.get());
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				log.info("jdk自带Future耗时：" + (System.currentTimeMillis() - s) + "ms");
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				final FutureData data = new FutureData();
				new Thread(new Runnable() {
					@Override
					public void run() {
						data.setRealData(new RealData());
					}
				}).start();
				doOtherTasks();
				doDataTask(data);
				log.info("自定义Future 耗时：" + (System.currentTimeMillis() - s) + "ms");
			}
		}).start();
	}
	
	private static void doOtherTasks() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void doDataTask(Data data) {
		log.info(Thread.currentThread().getName() + " 数据：" + data.getData());
	}

}
