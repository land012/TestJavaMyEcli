package com.umbrella.concurrent.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

public class CallableDemo {
	
	private static Logger log = Logger.getLogger(CallableDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		// 线程池 + Future 的用法，要用 List
		List<Future<Result>> list = new ArrayList<Future<Result>>();
		for(int i=1; i<=3; i++) {
			Future<Result> ft = exec.submit(new Task(i));
			list.add(ft);
		}
		for(Future<Result> ft : list) {
			try {
				Result temp = ft.get();
				log.info(temp.getDesc());  // 必须得任务执行完时，才能拿到，否则阻塞
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();    // 等待所有任务执行结束时，才会关闭线程池
//				exec.shutdownNow(); // 立即关闭线程池
			}
		}
		log.info("Demo finished!");
	}
	
	static class Task implements Callable<Result> {
		
		private int id;
		
		public Task(int id) {
			this.id = id;
		}

		@Override
		public Result call() throws Exception {
			log.info("任务 " + id + " start");
			long l = (long)(Math.random() * 1000);
			Thread.sleep(l);
			log.info("任务 " + id + " end");
			Result res = new Result();
			res.setCode("0");
			res.setDesc("任务 " + id + ", during=" + l);
			return res;
		}
		
	}

}
