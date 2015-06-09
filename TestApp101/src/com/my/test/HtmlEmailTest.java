package com.my.test;

import java.util.List;

import com.my.base.BaseTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class HtmlEmailTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HtmlEmail he = new HtmlEmail();
		try {
			he.addTo("1@admin.com");
		} catch (EmailException e) {
			e.printStackTrace();
		}
		List l = he.getToAddresses();
		for(Object s : l) {
			info.info(s);
		}
		
	}

}
