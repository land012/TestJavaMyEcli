package com.my.test3;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import com.my.thread.MyRunnable;


public class T4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*List<Integer> list = new LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(1, 11);
		list.set(2, 22);
		//list.add(5,7); // IndexOutOfBoundsException
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		for(int i : list) {
			System.out.println(i);
		}*/
		
		/*System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);*/
		
		// 显示指定月的最大日期
		/*Calendar cal = Calendar.getInstance();
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.getActualMaximum(Calendar.MONTH));
		System.out.println(cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.MONTH, 11);
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println(cal.getActualMaximum(Calendar.YEAR));
		System.out.println(cal.getActualMinimum(Calendar.YEAR));*/
		
		/*int x = 5;
		int y = 6;
		int[][] iarr = new int[x][y]; 
		for(int i=0; i<iarr.length; i++) {
			for(int j=0; j<iarr[i].length; j++) {
				System.out.print(iarr[i][j]);
			}
			System.out.println();
		}
		iarr[2*1][2*2+1] = 10;
		System.out.println(iarr[2*1][2*2+1]);*/
		
		// 启动线程
		new Thread(new MyRunnable()).start();
		
		// 数字格式规范
		DecimalFormat df = new DecimalFormat("###.##%");
		double d = 1.23455;
		//d = d * 100;
		System.out.println(df.format(d));
		
	}

}
