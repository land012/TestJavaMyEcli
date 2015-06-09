package com.my.test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.my.base.BaseTest;

public class JodaTest extends BaseTest {
	public static void main(String[] args) {
//		DateTime dt = new DateTime();
//		info.info(dt.toString("yyyy-MM-dd HH:mm:ss"));
//		
//		String str1 = "2012-12-12 14:40:00";
////		DateTime dt1 = DateTime.parse(str1); // 异常 java.lang.IllegalArgumentException，将 时间去掉不报异常
//		DateTime dt1 = DateTime.parse(str1, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
//		info.info(dt1.toString("yyyy-MM-dd HH:mm:ss"));
		
		DateTime dt2 = DateTime.parse("2013-04-30 12:12:00", DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		dt2 = dt2.plusDays(1);
		info.info(dt2.toString("yyyy-MM-dd HH:mm:ss"));
		
	}
}
