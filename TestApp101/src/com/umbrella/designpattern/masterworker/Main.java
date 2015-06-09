package com.umbrella.designpattern.masterworker;

import java.util.Map;

import org.apache.log4j.Logger;
/**
 * 
 * @author asdf
 * 为了在 Worker中使用 wait()，而对 taskQueue使用synchronized，但 taskQueue本身就是线程安全的
 *
 */
public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);
//	private static int i = 1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		Master master = new Master(new SquareWorker(), 2);
		int taskCount = 5; // 任务总数
		for(int i=1; i<=taskCount; i++) {
			master.addTask(i);
		}
		
//		master.process();
		Map<Object, Object> resultMap = master.getResultMap();
		
		long total = 0;
		
		while(!master.isComplete()) {
//			log.info("i=" + i++);
			for(Map.Entry<Object, Object> entry : resultMap.entrySet()) {
				log.info("统计任务：" + entry.getKey() + "," + resultMap.size());
				total += (Integer)entry.getValue();
				resultMap.remove(entry.getKey());
			}
		}
		
		System.out.println("耗时：" + (System.currentTimeMillis() - s) + "ms");
		System.out.println("最终结果：" + total);
		
		System.out.println(factorial(taskCount));
	}
	
	public static long factorial(int max) {
		long res = 0;
		for(int i=1; i<=max; i++) {
			res += i*i;
		}
		return res;
	}

}
