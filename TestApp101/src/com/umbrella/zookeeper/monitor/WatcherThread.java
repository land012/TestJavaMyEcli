package com.umbrella.zookeeper.monitor;

import org.apache.zookeeper.ZooKeeper;

public interface WatcherThread extends Runnable {
	public void setRoot(String root);
	public void setZk(ZooKeeper zk);
}
