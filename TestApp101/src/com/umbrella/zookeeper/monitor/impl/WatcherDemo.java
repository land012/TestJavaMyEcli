package com.umbrella.zookeeper.monitor.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import com.umbrella.util.Preferences;
import com.umbrella.zookeeper.monitor.WatcherThread;

public class WatcherDemo implements WatcherThread {
	
	private static Logger log = Logger.getLogger(WatcherDemo.class);
	
	private ZooKeeper zk;
	private String root;
	private Watcher watcher = new NodeWatcher();

	@Override
	public void run() {
		try {
			List<String> list = zk.getChildren(root, watcher);
			log.info(root + " list.size()=" + list.size());
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		WatcherDemo.log = log;
	}

	public ZooKeeper getZk() {
		return zk;
	}

	public void setZk(ZooKeeper zk) {
		this.zk = zk;
	}

	public String getRoot() {
		return root;
	}
	
	@Override
	public void setRoot(String root) {
		this.root = root;
	}

	class NodeWatcher implements Watcher {
		@Override
		public void process(WatchedEvent event) {
			if(event.getType() == Watcher.Event.EventType.NodeChildrenChanged) {
				int num = Integer.parseInt(Preferences.getProperty("zk_demo_client_num"));
				try {
					List<String> list = zk.getChildren(root, this);
					if(list.size()<num) {
						log.info("警告：有app挂掉了！");
					}
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info(event.getType());
			} else {
				log.info("其它事件类型！");
			}
		}
	}

}
