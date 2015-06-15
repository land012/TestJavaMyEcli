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
		 * ʵ�� Runnable �ӿڣ������̵߳ķ�ʽ
		 */
//		new MyRunnable();
//		new Thread(new MyRunnable()).start();
		
		/*
		 * �̳� Thread �����̵߳ķ�ʽ
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
	 * ���߳�û��ִ����ͱ�ǿ����ֹ�ˣ���Ϊ���ڵ�Ԫ�����У�
	 * ���̺߳����߳����첽��
	 */
	@Test
	public void test2() {
		new MyThread1().start();
		log.info("test2 end!");
	}
	
	/**
	 * һ��ʼ���̺߳��������첽��(����ִ�и��Ե�)
	 * �����������̵߳� join() ��ʽʱ�����߻�ȴ����߳�ִ�����ټ���ִ��
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
