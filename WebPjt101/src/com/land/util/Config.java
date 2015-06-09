package com.land.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static Properties p;
	
	public static void getProperties(InputStream is) {
		if(null == p) p = new Properties();
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		return p.getProperty(key);
	}
}
