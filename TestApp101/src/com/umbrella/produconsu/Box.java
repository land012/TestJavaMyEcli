package com.umbrella.produconsu;

import org.apache.log4j.Logger;
/**
 * ������������
 * @author asdf
 * ��Box��ʱ�������� wait()��������������ɺ󣬵��� notifyAll()
 * ��Box�ǿ�ʱ��������wait()��
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
