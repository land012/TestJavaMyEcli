package test.com.my.thread;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.my.thread.MyRunnable;
import com.my.thread.MyThread1;


public class MyRunnableTest {
	
	private static Logger log = Logger.getLogger(MyRunnableTest.class);

	@Test
	public void testRun() {
		/*
		 * 实现 Runnable 接口，启动线程的方式
		 */
//		new MyRunnable();
//		new Thread(new MyRunnable()).start();
		
		/*
		 * 继承 Thread 启动线程的方式
		 */
//		new MyThread1();
		new MyThread1().start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 子线程没有执行完就被强行中止了（因为是在单元测试中）
	 * 子线程和主线程是异步的
	 */
	@Test
	public void test2() {
		new MyThread1().start();
		log.info("test2 end!");
	}
	
	/**
	 * 一开始子线程和主线是异步的(各自执行各自的)
	 * 但当调用子线程的 join() 方式时，主线会等待子线程执行完再继续执行
	 */
	@Test
	public void test3() {
		Thread t1 = new MyThread1();
		t1.start();
		log.info("test3 ...2!");
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("test3 end!");
	}

}
