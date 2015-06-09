package com.my.test;

import java.util.Locale;

import com.my.base.BaseTest;

public class LocaleTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale[] larr = Locale.getAvailableLocales();
		for(Locale l : larr) {
			info.info(l);
		}
		
		String[] lan_arr = Locale.getISOLanguages();
//		for(String s : lan_arr) {
//			info.info(s);
//		}
		
		String[] c_arr = Locale.getISOCountries();
//		for(String c : c_arr) {
//			info.info(c);
//		}
		
		/*Locale[] ls = { Locale.CHINA, Locale.CHINESE, Locale.TAIWAN, Locale.JAPAN };
		for(Locale l : ls) {
			System.out.println("getCountry():" + l.getCountry());
			System.out.println("getDisplayCountry():" + l.getDisplayCountry());
			System.out.println("getLanguage():" + l.getLanguage());
			System.out.println("getDisplayLanguage():" + l.getDisplayLanguage());
			System.out.println("getDisplayName():" + l.getDisplayName());
			System.out.println("getVariant():" + l.getVariant());
			System.out.println("getDisplayVariant():" + l.getDisplayVariant());
			System.out.println("toString():" + l.toString());
			System.out.println("------------------");
		}*/
		
	}

}
