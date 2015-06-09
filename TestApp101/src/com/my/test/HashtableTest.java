package com.my.test;

import java.util.Arrays;
import java.util.Hashtable;


import com.my.base.BaseTest;

public class HashtableTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("k1", "v1");
//		info.info(ht.get("k1"));
		info.info(Arrays.toString(ht.values().toArray()));
		
//		// java.lang.NullPointerException
//		ht.put("k2", null);

	}

}
