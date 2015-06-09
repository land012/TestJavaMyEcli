package com.umbrella.calculate;

import org.apache.log4j.Logger;

public class Main {
	
	private static Logger log = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		log.info(CalcUtil.fn1(4, 4));
		
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}