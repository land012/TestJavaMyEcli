package com.umbrella.zookeeper.monitor;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.ZooKeeper;

import test.com.umbrella.zk.TestUtils;

import com.umbrella.util.Preferences;
import com.umbrella.zookeeper.zk.Constants;
/**
 * 告警程序
 * @author asdf
 *
 */
public class MonitorMain {
	
	private static Logger log = Logger.getLogger(MonitorMain.class);
	
	public static void main(String[] args) {
		ZooKeeper zk = null;
		try {
			zk = new ZooKeeper(TestUtils.getZkHost(),
					Constants.ZK_SESSION_TIMEOUT,
					null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		String[] watchNodes = StringUtils.split(Preferences.getProperty("zk_watch_nodes"), ",");
		if(watchNodes != null) {
			for(String node : watchNodes) {
				try {
					ScheduledExecutorService pool = Executors.newScheduledThreadPool(1); // 线程池
					WatcherThread watcher = (WatcherThread)Class.forName(Preferences.getProperty(node)).newInstance();
					watcher.setRoot(node);
					watcher.setZk(zk);
					pool.scheduleAtFixedRate(watcher,
							0,
							Long.parseLong(Preferences.getProperty("zk_watch_period")),
							TimeUnit.MILLISECONDS);
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} else {
			log.info("要监控的结点为空，程序退出！");
		}
	}
	
}
