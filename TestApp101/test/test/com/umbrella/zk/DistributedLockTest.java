package test.com.umbrella.zk;

import java.util.Timer;

import com.umbrella.util.Preferences;
import com.umbrella.zookeeper.Worker;

public class DistributedLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer t = new Timer();
		Worker w = new Worker(Preferences.getProperty("zkhost"), Preferences.getProperty("zknode"));
		t.scheduleAtFixedRate(w, 0, 3000);
	}

}
