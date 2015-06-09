package test.com.my.action;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.my.thread.SynThread1;
import com.my.thread.SynThread2;
import com.my.vo.CommonVo;

/**
 * ������
 * @author asdf
 *
 */
public class SynchronizedTest {
	
	
	/**
	 * ��̬������û������ͬ��
	 * �����⣬�߳�ͬʱ����
	 * @throws InterruptedException
	 */
	@Test
	public void testUnSyn() throws InterruptedException {
		Thread t1 = new Thread(new SynThread1());
		Thread t2 = new Thread(new SynThread2());
		
		t1.start();
		t2.start();
		Thread.sleep(10000);
	}
	
	/**
	 * ��̬����������ͬ��
	 * û����
	 * @throws InterruptedException 
	 */
	@Test
	public void testSyn() throws InterruptedException {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					CommonVo.increISyn();
				}
				System.out.println("r1:" + CommonVo.getI());
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					CommonVo.increISyn();
				}
				System.out.println("r2:" + CommonVo.getI());
			}
		};
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newCachedThreadPool();
		exec1.execute(r1);
		exec2.execute(r2);
		Thread.sleep(10000);
	}
	
	/**
	 * ��ͨ������û����ͬ��
	 * ��������⣬��Ϊһ���߳�һ������
	 * @throws InterruptedException 
	 */
	@Test
	public void testSyn2() throws InterruptedException {
		Runnable r1 = new Runnable() {
			CommonVo vo = new CommonVo();
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					vo.increJ();
				}
				System.out.println("r1:" + vo.getJ());
			}
		};
		Runnable r2 = new Runnable() {
			CommonVo vo = new CommonVo();
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					vo.increJ();
				}
				System.out.println("r2:" + vo.getJ());
			}
		};
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newCachedThreadPool();
		exec1.execute(r1);
		exec2.execute(r2);
		Thread.sleep(3000);
	}
	
	/**
	 * ������û����ͬ��
	 * ������
	 * @throws InterruptedException 
	 */
	@Test
	public void testSyn3() throws InterruptedException {
		Runnable r1 = new Runnable() {
			CommonVo vo = CommonVo.getInstance();
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					vo.increK();
				}
				System.out.println("r1:" + vo.getK());
			}
		};
		Runnable r2 = new Runnable() {
			CommonVo vo = CommonVo.getInstance();
			@Override
			public void run() {
				for(int i=0; i<10000000; i++) {
					vo.increK();
				}
				System.out.println("r2:" + vo.getK());
			}
		};
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newCachedThreadPool();
		exec1.execute(r1);
		exec2.execute(r2);
		Thread.sleep(2000);
	}
	
	/**
	 * ����������ͬ��
	 * û����
	 * @throws InterruptedException
	 */
	@Test
	public void testSyn4() throws InterruptedException {
		Runnable r1 = new Runnable() {
			CommonVo vo = CommonVo.getInstance();
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				for(int i=0; i<10000000; i++) {
					vo.increKSyn();
				}
				System.out.println("r1:" + vo.getK());
				System.out.println("r1 ִ��ʱ��(ms):" + (System.currentTimeMillis() - s));
			}
		};
		Runnable r2 = new Runnable() {
			CommonVo vo = CommonVo.getInstance();
			@Override
			public void run() {
				long s = System.currentTimeMillis();
				for(int i=0; i<10000000; i++) {
					vo.increKSyn();
				}
				System.out.println("r2:" + vo.getK());
				System.out.println("r2 ִ��ʱ��(ms):" + (System.currentTimeMillis() - s));
			}
		};
		ExecutorService exec1 = Executors.newCachedThreadPool();
		ExecutorService exec2 = Executors.newCachedThreadPool();
		exec1.execute(r1);
		exec2.execute(r2);
		Thread.sleep(7000);
	}
	
	@Test
	public void testTest() {
		System.out.print("a");
		System.out.println("b"); // ���������з���������һ��ʼ
	}
}
