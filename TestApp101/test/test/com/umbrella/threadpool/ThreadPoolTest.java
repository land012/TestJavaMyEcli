package test.com.umbrella.threadpool;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.umbrella.threadpool.ThreadPool;

public class ThreadPoolTest {
	private static final Logger log = Logger.getLogger(ThreadPoolTest.class);
	
	public static void main(String[] args) throws InterruptedException {
		ThreadPool pool = new ThreadPool(3);
		Thread.sleep(3000);
		
		for(int i=0; i<2; i++) {
			final int temp = i;
			pool.execute(new Runnable() {
				@Override
				public void run() {
					log.info("taskid=" + temp + " start!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info("taskid=" + temp + " end!");
				}
			});
		}
		
		//Thread.sleep(3000);
		
		pool.waitFinish();
		pool.closePool();
	}
	
	@Test
	public void test() throws InterruptedException {
		ThreadPool pool = new ThreadPool(3);
		Thread.sleep(3000);
		
		for(int i=0; i<5; i++) {
			final int temp = i;
			pool.execute(new Runnable() {
				@Override
				public void run() {
					log.info("taskid=" + temp + " start!");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					log.info("taskid=" + temp + " end!");
				}
			});
		}
		
		//Thread.sleep(3000);
		
		pool.waitFinish();
		pool.closePool();
	}
}
