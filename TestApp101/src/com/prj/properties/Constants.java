package com.prj.properties;

public class Constants {
	public static final int C1 = SystemUtils.getProperty("k1")==null?-1:Integer.parseInt(SystemUtils.getProperty("k1"));
}
