package test.com.my.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import com.my.thread.HelloWorldThread;

public class HelloWorldThreadTest {
	static ExecutorService execs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		execs = Executors.newCachedThreadPool();
		System.out.println(System.currentTimeMillis() + " I am BeforeClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println(System.currentTimeMillis() + " I am Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println(System.currentTimeMillis() + " I am After");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		execs.shutdown();
		System.out.println(System.currentTimeMillis() + " I am AfterClass");
	}
	
	/**
	 * 有时候会不打印  HelloWorldThread 中内容的原因
	 * junit 线程执行的快，而 HelloWorldThread 执行的慢，
	 * junit 的执行完后就关闭了，同时也关闭了 HelloWorldThread，所以就会看不到打印
	 * @throws InterruptedException
	 */
	@Test
	public void testHelloThreadrun() throws InterruptedException {
		System.out.println(System.currentTimeMillis() + " begin");
		execs.execute(new HelloWorldThread());
		Thread.sleep(1000);
		System.out.println(System.currentTimeMillis() + " end");
	}
	
	public static void main(String[] args) {
		// 执行完毕后，程序结束
//		new Thread(new HelloWorldThread()).start();
		
		// 正常执行，程序会一直驻留
		ExecutorService execs = Executors.newCachedThreadPool();
		execs.execute(new HelloWorldThread());
		
		// 这一步会等  HellowWorldThread 执行完毕才会执行，面不会强行关闭 HelloWorldThread
		execs.shutdown();
		
		// 这一步会优先执行到，然后等待 HelloWorldThread 执行结束
		System.out.println(System.currentTimeMillis() + " This is test's main!");
		
		// 如果加上这一句，程序结束，HelloWorldThread 还没执行完毕就会被强制结束
		//System.exit(-1);
	}

}
