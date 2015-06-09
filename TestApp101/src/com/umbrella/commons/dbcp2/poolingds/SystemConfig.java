package com.umbrella.commons.dbcp2.poolingds;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.sql.DataSource;

import common.Logger;

public class SystemConfig {
	
	private static Logger log = Logger.getLogger(SystemConfig.class);
	
	private static ConcurrentMap<String, DataSource> dss;
	
	private SystemConfig() { }
	
	public static void init() {
		log.info("系统初始化了...");
		
		dss = new ConcurrentHashMap<String, DataSource>();
		
		// 初始化数据源
		DBPool test = new DBPool("jdbc:mysql://localhost:3306/test", "root", "123456");
		dss.put("test", test.getDs());
		
		DBPool diskmgmt = new DBPool("jdbc:mysql://localhost:3306/diskmgmt", "root", "123456");
		dss.put("diskmgmt", diskmgmt.getDs());
	}
	
	public static DataSource getDataSource(String dsName) {
		return dss.get(dsName);
	}
}
