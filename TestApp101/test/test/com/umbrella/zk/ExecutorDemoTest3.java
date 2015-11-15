package test.com.umbrella.zk;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;

import com.umbrella.zookeeper.zk.ExecutorDemo;

public class ExecutorDemoTest3 {
	
	private static Logger log = Logger.getLogger(ExecutorDemoTest3.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorDemo.Barrier b = new ExecutorDemo.Barrier("192.168.0.102:2181,192.168.0.102:2182",
				"/zookeeper/demo",
				3);
		try {
			boolean flag = b.enter();
			log.info(flag);
			Thread.sleep(60 * 1000);
			b.leave();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
