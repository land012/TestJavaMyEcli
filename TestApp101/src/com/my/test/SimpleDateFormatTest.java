package com.my.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.my.base.BaseTest;

public class SimpleDateFormatTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SimpleDateFormat sdf1 = new SimpleDateFormat("M-d");
//		String str1 = "5-20";
//		try {
//			Date d1 = sdf1.parse(str1);
//			info.info(d1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf1.parse("2012-1-1");
			info.info(sdf1.format(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}

}
