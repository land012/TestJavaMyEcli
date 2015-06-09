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
		// �̳߳� + Future ���÷���Ҫ�� List
		List<Future<Result>> list = new ArrayList<Future<Result>>();
		for(int i=1; i<=3; i++) {
			Future<Result> ft = exec.submit(new Task(i));
			list.add(ft);
		}
		for(Future<Result> ft : list) {
			try {
				Result temp = ft.get();
				log.info(temp.getDesc());  // ���������ִ����ʱ�������õ�����������
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();    // �ȴ���������ִ�н���ʱ���Ż�ر��̳߳�
//				exec.shutdownNow(); // �����ر��̳߳�
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
			log.info("���� " + id + " start");
			long l = (long)(Math.random() * 1000);
			Thread.sleep(l);
			log.info("���� " + id + " end");
			Result res = new Result();
			res.setCode("0");
			res.setDesc("���� " + id + ", during=" + l);
			return res;
		}
		
	}

}
