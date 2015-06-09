package com.my.util;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * ºº×Ö°´Æ´ÒôË³Ðò±È½Ï
 * @author asdf
 *
 * @param <T>
 */
public class ChineseComparator<T> implements Comparator<T> {
	
	private Collator collator = Collator.getInstance(Locale.CHINA);

	@Override
	public int compare(T o1, T o2) {
		if(o1 instanceof String && o2 instanceof String) {
			String s1 = (String)(o1);
			String s2 = (String)(o2);
			CollationKey k1 = collator.getCollationKey(s1);
			CollationKey k2 = collator.getCollationKey(s2);
			return k1.compareTo(k2);
		}
		return 0;
	}

}
