package com.my.test;

import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

import com.my.base.BaseTest;

public class TimeZoneTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = TimeZone.getAvailableIDs();
		info.info(arr.length);
		for(String s : arr) {
			info.info(s);
//			if(StringUtils.length(s)<=3) {
//				info.info(s);
//			}
		}
	}

}
