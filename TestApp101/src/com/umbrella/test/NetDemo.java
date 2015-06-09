package com.umbrella.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;

public class NetDemo {
	
	private static Logger log = Logger.getLogger(NetDemo.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			log.info(InetAddress.getLocalHost().getCanonicalHostName()); // land-PC
			log.info(InetAddress.getLocalHost().getHostName());          // land-PC
			log.info(InetAddress.getLocalHost().getHostAddress());       // 192.168.54.116
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
