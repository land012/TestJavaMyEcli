package com.umbrella.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CommonUtils {
	
	/**
	 * ��ȡ����IP
	 * @return
	 */
	public static String getLocalIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
}
