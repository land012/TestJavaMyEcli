package com.umbrella.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Preferences {
	
	private static Logger log = Logger.getLogger(Preferences.class);
	
	private static Properties p;
	
	static {
		p = new Properties();
		try {
			p.load(new FileInputStream("ini/test.properties"));
		} catch (FileNotFoundException e) {
			log.info("加载配置文件异常", e);
		} catch (IOException e) {
			log.info("加载配置文件异常", e);
		}
	}
	
	public static String getProperty(String key) {
		return p.getProperty(key);
	}

}
