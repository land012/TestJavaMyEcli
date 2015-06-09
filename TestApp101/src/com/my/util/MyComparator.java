package com.my.util;

import java.util.Comparator;

public class MyComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		if(o1 instanceof String) {
			return ((String)o1).compareTo((String)o2);
		} else if (o1 instanceof String[]) {
			String[] l_o1 = (String[])o1;
			String[] l_o2 = (String[])o2;
			return l_o1[0].compareTo(l_o2[0]);
		}
		return 0;
	}

}
