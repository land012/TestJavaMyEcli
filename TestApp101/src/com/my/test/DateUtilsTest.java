package com.my.test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.my.base.BaseTest;

public class DateUtilsTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "2012-12-12";
		String str2 = "2012-12-15";
		String str3 = "2013-01-06 13:12:12";
		
		try {
			Date d1 = DateUtils.parseDate(str1, "yyyy-MM-dd");
			Date d2 = DateUtils.parseDate(str2, "yyyy-MM-dd");
			Date d3 = DateUtils.parseDate(str3, "yyyy-MM-dd HH:mm:ss");
			
			/*
			 * 参数1 < 参数2，-1
			 * 参数1 > 参数2，1
			 * 参数1 = 参数2，0
			 */ 
			info.info(DateUtils.truncatedCompareTo(d1, d2, Calendar.DAY_OF_MONTH));
			info.info(d3);
			info.info(DateUtils.ceiling(d3, Calendar.MINUTE));
			info.info(DateUtils.truncate(d3, Calendar.HOUR_OF_DAY));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
