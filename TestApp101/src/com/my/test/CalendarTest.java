package com.my.test;

import java.util.Calendar;
import java.util.Date;

import com.my.base.BaseTest;

public class CalendarTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		info.info("�£�" + cal.get(Calendar.YEAR));
//		info.info("�£�" + cal.get(Calendar.MONTH));
//		info.info("�գ�" + cal.get(Calendar.DAY_OF_MONTH));
//		info.info("�ܣ�" + cal.get(Calendar.DAY_OF_WEEK));
//		info.info(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		
//		info.info("==========================");
//		cal.set(2013, 2, 12, 12, 12, 12);
//		info.info("�£�" + cal.get(Calendar.MONTH));
//		info.info("�գ�" + cal.get(Calendar.DAY_OF_MONTH));
//		info.info("�ܣ�" + cal.get(Calendar.DAY_OF_WEEK));
//		info.info(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
//		info.info(cal.getTime());
		
//		Calendar cal1 = Calendar.getInstance(); // 3 �� 31��
//		info.info("��_��С�����ֵ��" + cal1.getLeastMaximum(Calendar.DAY_OF_MONTH)); // 28
//		info.info("��_���ֵ��" + cal1.getMaximum(Calendar.DAY_OF_MONTH)); // 31
//		info.info("��_ʵ�����ֵ��" + cal1.getActualMaximum(Calendar.DAY_OF_MONTH)); // �������ֵ
//		
//		info.info("��_��С�����ֵ��" + cal1.getLeastMaximum(Calendar.MONTH)); // 11
//		info.info("��_���ֵ��" + cal1.getMaximum(Calendar.MONTH)); // 11
//		info.info("��_ʵ�����ֵ��" + cal1.getActualMaximum(Calendar.MONTH)); // 11
//		Calendar cal2 = (Calendar)cal1.clone();
//		cal1.set(Calendar.MONTH, 1);
//		info.info(cal1.getTime()); // Sun Mar 03 16:28:00 CST 2013
//		cal1.set(Calendar.DAY_OF_MONTH, 1);
//		info.info(cal1.getTime()); // Fri Mar 01 09:42:45 CST 2013
//		cal2.set(Calendar.MONTH, 1);
//		cal2.set(Calendar.DAY_OF_MONTH, 1);
//		info.info(cal2.getTime()); // Fri Feb 01 09:42:45 CST 2013
//		info.info("�����ֵ��" + cal1.getActualMaximum(Calendar.DAY_OF_MONTH));
		
//		Calendar cal = Calendar.getInstance();
//		info.info("Calendar.MONDAY=" + Calendar.MONDAY);
//		cal.setFirstDayOfWeek(Calendar.MONDAY); // ÿ�ܵĵ�һ��Ϊ��һ
////		info.info(cal.get(Calendar.DAY_OF_WEEK));
//		cal.set(Calendar.DAY_OF_WEEK, 2); // ����Ϊ��һ
//		info.info(cal.getTime());
//		
//		info.info(cal.get(Calendar.DATE));
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.toString());
		Date d = cal.getTime();
		System.out.println(d.toString());
		System.out.println("Calendar.HOUR" + cal.get(Calendar.HOUR)); // 12Сʱ��
		System.out.println("Calendar.HOUR_OF_DAY" + cal.get(Calendar.HOUR_OF_DAY)); // 24 Сʱ��
		System.out.println("Calendar.MINUTE:" + cal.get(Calendar.MINUTE));
		System.out.println("Calendar.MONTH:" + cal.get(Calendar.MONTH));
		System.out.println("Calendar.DAY_OF_MONTH:" + cal.get(Calendar.DAY_OF_MONTH));
	}

}
