package com.land.main;

import java.util.ArrayList;
import java.util.List;

import com.land.main.BaseTest;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class HtmlEmailTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HtmlEmail he = new HtmlEmail();
		try {
			he.addTo("1@admin.com", "1");
			he.addTo("2@admin.com", "2");
			// “Ï≥£ java.lang.NullPointerException
//			he.addTo(null);
			// “Ï≥£ org.apache.commons.mail.EmailException: Illegal address
//			he.addTo("");
//			List list = new ArrayList();
//			he.setTo(list);
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		List l = he.getToAddresses();
		for(Object s : l) {
			log.info(s);
		}
		
	}

}
