package com.umbrella.zookeeper;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class DistributedLock implements Watcher {
	
	private static Logger log = Logger.getLogger(DistributedLock.class);
	
	static ZooKeeper zk = null;
	String root;
	
	public DistributedLock(String address) {
		if(zk == null) {
			try {
				zk = new ZooKeeper(address, 3000, this);
//				log.info("zk connected, sessoinid=" + zk.getSessionId()); // ���ʱ���ò���sessionid��sessionid Ϊ 0
			} catch (IOException e) {
				e.printStackTrace();
				zk = null;
			}
		}
	}

	@Override
	public void process(WatchedEvent event) {
		log.info(event.getType());
		log.info("zk connected, sessoinid=" + zk.getSessionId()); // ���ʱ������õ�sessionid��
	}
	
	public static class Barrier extends DistributedLock {
		
		String filenamePrefix;
		
		public Barrier(String address, String root) {
			super(address);
			this.root = root;
			
			if(zk != null) {
				try {
					Stat s = zk.exists(root, false);
					if(s == null) {
						zk.create(root,
								new byte[0],
								Ids.OPEN_ACL_UNSAFE,
								CreateMode.PERSISTENT);
					}
				} catch (KeeperException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			try {
				filenamePrefix = InetAddress.getLocalHost().getCanonicalHostName();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		
		/**
		 * ������ʱ���
		 * @return
		 * @throws KeeperException
		 * @throws InterruptedException
		 */
		public String enter() throws KeeperException, InterruptedException {
			String pfname = zk.create(root + Constants.ZK_PATHSEPARATOR + filenamePrefix + Constants.NAME_SEPARATOR,
					new byte[0],
					Ids.OPEN_ACL_UNSAFE,
					CreateMode.EPHEMERAL_SEQUENTIAL);
			log.info("�½��ڵ� ·���ļ�����" + pfname);
			return pfname;
		}
		
		/**
		 * ����Ƿ�����
		 * @param pfname �����ļ�·����
		 * @return
		 * ���к���С�Ľ���õ���
		 */
		public boolean getLock(String pfname) {
			String root = StringUtils.substring(pfname, 0, StringUtils.lastIndexOf(pfname, Constants.ZK_PATHSEPARATOR));
			String filename = StringUtils.substring(pfname, StringUtils.lastIndexOf(pfname, Constants.ZK_PATHSEPARATOR) + 1);
			String seq = StringUtils.substring(filename, StringUtils.lastIndexOf(filename, Constants.NAME_SEPARATOR) + 1);
			long myid = Long.parseLong(seq);
//			log.info("root=" + root);
			boolean flag = true;
			try {
				List<String> list = zk.getChildren(root, false);
				for(String s : list) {
					long tempid = Long.parseLong(StringUtils.substring(s, StringUtils.lastIndexOf(s, Constants.NAME_SEPARATOR) + 1));
					if(tempid<myid) {
						flag = false; // ˵���бȵ�ǰ���С�Ľ��
						break;
					}
				}
			} catch (KeeperException e) {
				e.printStackTrace();
				flag = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
				flag = false;
			}
			if(flag) {
				log.info("�õ��˷ֲ�ʽ����" + pfname);
			} else {
				log.info("û�õ��ֲ�ʽ����" + pfname);
			}
			return flag;
		}
		
	}

}
