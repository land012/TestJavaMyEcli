package com.umbrella.zookeeper.zk;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ExecutorDemo implements Watcher {
	
	private static Logger log = Logger.getLogger(ExecutorDemo.class);
	
	static ZooKeeper zk = null;
	static Integer mutex;
	String root;
	
	public ExecutorDemo(String address) {
		if(zk == null) {
			try {
				zk = new ZooKeeper(address, 3000, this);
				mutex = new Integer(-1);
				log.info("zk started, sessoinid=" + zk.getSessionId());
			} catch (IOException e) {
				e.printStackTrace();
				zk = null;
			}
		}
	}

	@Override
	public void process(WatchedEvent event) {
		synchronized(mutex) {
			log.info("唤醒 mutex");
			mutex.notify();
		}
	}
	
	static public class Barrier extends ExecutorDemo {
		int size;
		String name;
		
		public Barrier(String address, String root, int size) {
			super(address);
			this.root = root;
			this.size = size;
			
			if(zk != null) {
				try {
					Stat s = zk.exists(root, false);
					if(s == null) {
						zk.create(root, new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
					}
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				name = InetAddress.getLocalHost().getCanonicalHostName();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		
		public boolean enter() throws KeeperException, InterruptedException {
			String pathfilename = zk.create(root + "/" + name, new byte[0], Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
			log.info("新建节点 路径文件名：" + pathfilename);
			while(true) {
				synchronized(mutex) {
					List<String> list = zk.getChildren(root, true);
					log.info("list.size()=" + list.size());
					if(list.size() < size) {
						mutex.wait();
					} else {
						return true;
					}
				}
			}
		}
		
		public boolean leave() throws InterruptedException, KeeperException {
			zk.delete(root + "/" + name, 0);
			while(true) {
				List<String> list = zk.getChildren(root, true);
				log.info("list.size()=" + list.size());
				if(list.size()>0) {
					mutex.wait();
				} else {
					return true;
				}
			}
		}
		
	}

}
