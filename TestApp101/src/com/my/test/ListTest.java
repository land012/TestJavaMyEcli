package com.my.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.my.base.BaseTest;
import com.umbrella.vo.User;

public class ListTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		if(list1 != null) {
			// 运行时 异常 java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
			//info.info(list.get(0));
//			info.info(list.size());
		} else {
//			info.info("list is NULL");
		}
		
		list1.add("a");
		list1.add("b");
		list1.add("c");
		String[] arr1 = new String[list1.size()];
//		// 异常 java.lang.ClassCastException: [Ljava.lang.Object;
//		arr1 = (String[])list.toArray();
		
		list1.toArray(arr1); // {"a", "b", "c"}
//		for(String s : arr1) {
//			info.info(s);
//		}
		
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("d");
		list2.add("e");
		Object[] arr2 = (Object[])list2.toArray();
		info.info(arr2.length); // 2
		// 异常 java.lang.ClassCastException: [Ljava.lang.Object;
//		String[] arr3 = (String[])arr2;
		for(Object o : arr2) {
			String str1 = (String)o; // 这样不会出错
			info.info(str1);
		}
		
//		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> hm1 = new HashMap<String, String>();
//		hm1.put("k1", "v11");
//		hm1.put("k2", "v12");
//		HashMap<String, String> hm2 = new HashMap<String, String>();
//		hm2.put("k1", "v21");
//		hm2.put("k2", "v22");
//		list.add(hm1);
//		list.add(hm2);
//		for(HashMap<String, String> hm : list) {
//			info.info("k1:" + hm.get("k1"));
//			info.info("k2:" + hm.get("k2"));
//		}
		
		/*
		 * list 为 null，下面的判断方式，不会报 NullPointer 错
		 */
//		List<String> list3 = null;
//		if(list1 != null && list1.size()>0) {
//			info.info("1");
//		} else {
//			info.info("2");
//		}
		
		/**
		 * 修改 List 中的对象的属性值
		 */
		User u1 = new User();
		u1.setName("tom");
		List list = new ArrayList();
		list.add(u1);
		User u2 = (User)list.get(0);
		u2.setName("jim");
		User u3 = (User)list.get(0);
		System.out.println(u3.getName());
	}

}
