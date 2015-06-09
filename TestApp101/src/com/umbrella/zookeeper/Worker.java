package com.umbrella.zookeeper;

import java.util.TimerTask;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.zookeeper.KeeperException;

public class Worker extends TimerTask {
	
	private static Logger log = Logger.getLogger(Worker.class);
	
	DistributedLock.Barrier barrier;
	
	private String pfname;
	
	public Worker(String host, String root) {
		barrier = new DistributedLock.Barrier(host, root);
		try {
			pfname = barrier.enter();
		} catch (KeeperException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		if(barrier.getLock(pfname)) {
			log.info("i am worker "
					+ StringUtils.substring(pfname, StringUtils.lastIndexOf(pfname, Constants.NAME_SEPARATOR) + 1)
					+ ", now=" + System.currentTimeMillis());
		}
	}

}
