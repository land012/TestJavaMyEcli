package test.com.umbrella.zk;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;

import com.umbrella.util.Preferences;
import com.umbrella.zookeeper.zk.ExecutorDemo;

public class ExecutorDemoTest2 {
	
	private static Logger log = Logger.getLogger(ExecutorDemoTest2.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorDemo.Barrier b = new ExecutorDemo.Barrier(Preferences.getProperty("zkhost"),
				Preferences.getProperty("zknode"),
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
