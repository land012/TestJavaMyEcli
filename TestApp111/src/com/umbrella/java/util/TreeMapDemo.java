package com.umbrella.java.util;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		Map<String, String> tmap = new TreeMap<String, String>();
//		tmap.put(null, "v1"); // key 不可以是null
		tmap.put("k2", null);
	}

}
