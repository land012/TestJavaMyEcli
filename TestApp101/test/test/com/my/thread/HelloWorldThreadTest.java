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
	 * ��ʱ��᲻��ӡ  HelloWorldThread �����ݵ�ԭ��
	 * junit �߳�ִ�еĿ죬�� HelloWorldThread ִ�е�����
	 * junit ��ִ�����͹ر��ˣ�ͬʱҲ�ر��� HelloWorldThread�����Ծͻῴ������ӡ
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
		// ִ����Ϻ󣬳������
//		new Thread(new HelloWorldThread()).start();
		
		// ����ִ�У������һֱפ��
		ExecutorService execs = Executors.newCachedThreadPool();
		execs.execute(new HelloWorldThread());
		
		// ��һ�����  HellowWorldThread ִ����ϲŻ�ִ�У��治��ǿ�йر� HelloWorldThread
		execs.shutdown();
		
		// ��һ��������ִ�е���Ȼ��ȴ� HelloWorldThread ִ�н���
		System.out.println(System.currentTimeMillis() + " This is test's main!");
		
		// ���������һ�䣬���������HelloWorldThread ��ûִ����Ͼͻᱻǿ�ƽ���
		//System.exit(-1);
	}

}
