package com.umbrella.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 公共子串
 * @author asdf
 *
 */
public class CommonSubstring {
	
	private static Logger log = Logger.getLogger(CommonSubstring.class);
	
	public static String exec(String str1, String str2) {
		String comstr = null; // 公共子串
		int len1, len2, maxLength;
		Map<Integer, List<int[]>> res = null; // 记录下所有的公共子串
		
		if(str1 == null || "".equals(str1) || str2 == null || "".equals(str2)) {
			return comstr;
		}
		
		len1 = str1.length();
		len2 = str2.length();
		maxLength = -1;
		res = new HashMap<Integer, List<int[]>>();
		List<String> maxStrList = null;
		
		// 初始化数组，所以 0行，0列 置为 0
		int[][] c = new int[len1+1][len2+1];
		for(int i=0; i<=len1; i++)
			c[i][0] = 0;
		for(int j=0; j<=len2; j++)
			c[0][j] = 0;
		
		for(int i=0; i<len1; i++) {
			for(int j=0; j<len2; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					c[i+1][j+1] = c[i][j] + 1;
				} else {
					c[i+1][j+1] = 0;
				}
				
				if(c[i+1][j+1]>0) {
					List<int[]> list = res.get(c[i+1][j+1]);
					if(list == null) {
						list = new ArrayList<int[]>();
						int l[] = new int[2];
						l[0] = i + 1;
						l[1] = j + 1;
						list.add(l);
						res.put(c[i+1][j+1], list);
					} else {
						int l[] = new int[2];
						l[0] = i + 1;
						l[1] = j + 1;
						list.add(l);
					}
				}
				
				if(c[i+1][j+1]>maxLength) {
					maxLength = c[i+1][j+1];
				}
			}
		}
		
		log.info("最长子串长度：" + maxLength);
		maxStrList = new ArrayList<String>();
		List<int[]> list = res.get(maxLength); // 获取最长子串
		for(int[] arr : list) {
			int end = arr[0];
			int begin = end - maxLength;
			String substr = str1.substring(begin, end);
			maxStrList.add(substr);
			log.info("最长公共子串：" + substr);
		}
		
		return comstr;
	}
}
