package com.umbrella.produconsu;

import org.apache.log4j.Logger;
/**
 * 生产者消费者
 * @author asdf
 * 当Box空时，消费者 wait()，生产者生产完成后，调用 notifyAll()
 * 当Box非空时，生产者wait()，
 *
 */
public class Box {
	
	private static Logger log = Logger.getLogger(Box.class);
	
	private String msg;
	private boolean empty = true;
	
	public synchronized String take() {
		while(empty) {
			log.info("box is empty, wait for produce");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("box is not empty, consuming : " + msg);
		empty = true;
		notifyAll();
		return msg;
	}
	
	public synchronized void put(String msg) {
		while(!empty) {
			log.info("box is not empty, wait for consume");
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		log.info("box is empty, producing : " + msg);
		empty = false;
		this.msg = msg;
		notifyAll();
	}
}
