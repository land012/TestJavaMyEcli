package com.my.base;

import org.apache.log4j.Logger;

public class BaseTest {
	public static Logger log = Logger.getLogger("logs");    // 后台打印，并输出到日志
	public static Logger info = Logger.getLogger("stdout"); // 仅后台打印
}
