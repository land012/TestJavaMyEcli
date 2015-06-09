package com.my.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.my.base.BaseTest;

public class MapTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		HashMap<String, String> hm = getHashMap();
//		info.info("k1的值：" + hm.get("k1"));
		
//		HashMap hm1 = new HashMap();
//		hm1.put("k1", "v1");
//		List list1 = new ArrayList();
//		list1.add("l1");
//		list1.add("l2");
//		hm1.put("k2", list1);
//		info.info(hm1.get("k1"));
//		
//		List list2 = (ArrayList)hm1.get("k2");
//		Iterator it = list2.iterator();
//		while(it.hasNext()) {
//			info.info(it.next());
//		}
		
//		TreeMap<String, String> tm1 = new TreeMap<String, String>();
//		tm1.put("d", "dv");
//		tm1.put("x", "xv");
//		tm1.put("n", "nv");
//		tm1.put("q", "qv");
//		tm1.put("w", "wv");
//		tm1.put("e", "ev");
//		
//		// 逆序得到 key
////		NavigableSet<String> set1 = tm1.descendingKeySet();
////		Iterator<String> it1 = set1.iterator();
////		while(it1.hasNext()) {
////			info.info(it1.next());
////		}
//		
//		info.info(tm1.lastKey());
//		tm1.remove("a");
//		System.out.println(tm1); // 打印 Map
		
		Map<String, String> m2 = new ConcurrentHashMap<String, String>();
		m2.remove("k1");

	}
	/**
	 * 返回 hashMap
	 * @return
	 */
	public static HashMap<String, String> getHashMap() {
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("k1", "v1");
		return hashMap;
	}

}
