package com.umbrella.concurrent;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.log4j.Logger;

public class ThreadLocalRandomDemo {
	
	private static Logger log = Logger.getLogger(ThreadLocalRandomDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info(ThreadLocalRandom.current().nextInt());
		log.info(ThreadLocalRandom.current().nextInt(10));    // 0-9
		log.info(ThreadLocalRandom.current().nextInt(9, 11)); // 9-10
//		log.info(ThreadLocalRandom.current().nextInt(9, 9));  // java.lang.IllegalArgumentException
	}

}
