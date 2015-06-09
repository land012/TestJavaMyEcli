package com.my.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import com.my.base.BaseTest;

public class CollectionUtilsTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list1 = null;
//		info.info(CollectionUtils.isEmpty(list1)); // true
//		// “Ï≥£ java.lang.IllegalArgumentException
////		info.info(CollectionUtils.size(list1));
		list1 = new ArrayList<String>();
		info.info(CollectionUtils.isEmpty(list1)); // true
//		info.info(CollectionUtils.isNotEmpty(list1)); // false
//		info.info(list1.size());
//		list1.add("v1");
//		info.info(CollectionUtils.isEmpty(list1));
		
		HashMap<String, String> hm1 = null;
		HashMap<String, String> hm2 = new HashMap<String, String>();
		info.info(MapUtils.isEmpty(hm1)); // true
		info.info(MapUtils.isEmpty(hm2)); // true
		
	}

}
