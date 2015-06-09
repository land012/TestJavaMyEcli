package com.prj.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class SystemUtils {
	private static Properties p = null;
	
	public static void init() {
		p = new Properties();
		try {
			p.load(new FileInputStream("files/file2.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key) {
		String rs = StringUtils.trimToEmpty(p.getProperty(key));
		if(StringUtils.isEmpty(rs)) {
			rs = null;
		}
		return rs;
	}
}
