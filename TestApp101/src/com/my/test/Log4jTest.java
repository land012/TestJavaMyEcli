package com.my.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//PropertyConfigurator.configure("ini/log4j.properties");
		
		/*
		 * log4j 日志文件示例：
		 * 2012-12-27 15:44:13,325 INFO [main] Log4jTest.main(16) | 日志1
		 * 2012-12-27 15:44:13,325 DEBUG [main] Log4jTest.main(17) | 日志debug
		 */
		Logger log = Logger.getLogger("logs");
		log.info("日志1");
		log.debug("日志debug");
		
		/*
		 * log4j 只后台打印，不输出到日志文件
		 */
		Logger stdout = Logger.getLogger("stdout");
		stdout.info("stdout0001");
		
		/*
		 * log 使用这个简化 Log 时，日志文件中，仅保存日志打印的内容，而没有时间等其它信息
		 * 例：
		 * 日志001
		 * 日志debug001
		 */
		Log log1 = LogFactory.getLog("logs2");
		log1.info("日志001");
		log1.debug("日志debug001"); // 没有打印到控制台
	}

}
