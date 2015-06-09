package com.my.test1;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;

import com.my.util.MyPrintUtils;

/**
 * Calendar, SimpleDateFormat, DateTime
 * Integer.parseInt()
 * DecimalFormat ������
 * �����鸳ֵ fillArr(int[][] arr)
 * @author xudz
 *
 */
public class T3 {

	public static void main(String[] args) {
		// Calendar �Ӽ�
		Calendar cal = Calendar.getInstance(); // ��ǰʱ��Ϊ 2012-11-23 24:16:22
//		cal.add(Calendar.MONTH, -1);
//		System.out.println(cal.getTime().toString());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss"); // 1-24Сʱ��
		Date d1 = cal.getTime();
		//MyUtils.print(sdf.format(d1));
		Date d2 = null;
		try {
			d2 = sdf.parse("2012-11-23 01:01:01");
//			MyUtils.print(d2.toString());
		} catch (ParseException e) {
			MyPrintUtils.print("��������ʧ��");
		}
//		MyUtils.print(cal.getTime().compareTo(d2)); // -1����ǰʱ��(2012-11-23 24:01:01)��С�� 2012-11-23 01:01:01
		sdf.applyPattern("HH:mm:ss");
//		MyUtils.print(sdf.toPattern()); // HH:mm:ss
//		MyUtils.print(sdf.toString()); // java.text.SimpleDateFormat@8140d380
//		MyUtils.print(sdf.format(d1));
		int sendHour = 9; // ���͵�ʱ��Ĭ�� 9:00 ����
		int sendMinute =0; // ���͵ķ�
		try {
//			Date d3 = sdf.parse("12:12:12"); // Thu Jan 01 12:12:12 CST 1970
//			Date d3 = sdf.parse("24:11:12"); // Fri Jan 02 00:11:12 CST 1970���Զ���ʱ���Ϊ���������������쳣
			Date d3 = sdf.parse("12:11:06");
//			MyUtils.print(sdf.format(d3));
			//MyUtils.print(sdf.format(d3));
			cal.setTime(d3);
			sendHour = cal.get(Calendar.HOUR_OF_DAY);
			sendMinute = cal.get(Calendar.MINUTE);
//			MyUtils.print(sendHour + "," + sendMinute);
		} catch (ParseException e) { // �����õ�ʱ����ֽ����쳣ʱ������ΪĬ�� 9:00
			MyPrintUtils.print("���ڽ���ʧ�ܣ�");
			sendHour = 9;
			sendMinute = 0;
		}
		
		Date d = null;
		//sdf.applyPattern("yyyy-MM-dd HH:mm:ss"); // ���� "2011-11-5" ʱ����
		sdf.applyPattern("yyyy-MM-dd");
		try {
			d = sdf.parse("2011-11-5");
		} catch (ParseException e) {
			MyPrintUtils.print("���ڽ�������");
			d = new Date();
		}
//		cal.setTime(d);
//		MyUtils.print(d.toString());
//		MyUtils.print(cal.get(Calendar.YEAR));
//		MyUtils.print(cal.get(Calendar.MONTH));
		
		//String str1 = "2012-11-12 23:59:59";
		String str1 = "2012-11-12 23:59:59";
		String str2 = "2012-12-12 00:00:01";
		/*try {
			MyUtils.print(DateUtils.truncatedCompareTo(sdf.parse(str1), sdf.parse(str2), Calendar.DAY_OF_MONTH));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		// Joda ȡ�������������
		//DateTime dt1 = DateTime.parse(str1, DateTimeFormat.forPattern("yyyy-MM-dd"));
		/*
		 * �������ڣ�ָ�� pattern �����ַ���ƥ��
		 * �������ַ���ֻ������û��ʱ��ʱ��ģʽ�в�����ʱ��
		 * ���ַ�����ʱ��ʱ��ģʽ��Ҳ������ʱ��
		 */
		
		DateTime dt1 = DateTime.parse(str1, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
		DateTime dt2 = DateTime.parse(str2, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss"));
//		MyUtils.print(dt1.toString(DateTimeFormat.forPattern("yyyy-MM-dd")));
//		MyUtils.print(dt1.toString(DateTimeFormat.forStyle("MM")));
//		MyUtils.print(dt2.toString(DateTimeFormat.forStyle("SL")));
		
		MyPrintUtils.print(dt1.dayOfMonth().toString());
		/*
		 * ��ʵ��ʱ�䲻��һ��ʱ�����ᰴһ�����
		 * ����2012-12-11 23:59:59 �� 2012-12-12 00:00:01�����Ϊ 0
		 */
		MyPrintUtils.print(Days.daysBetween(dt1, dt2).getDays());
		
		
		// Integer �� parseInt(String)
//		String str1 = "1";
//		String str2 = "2";
//		System.out.println(Integer.parseInt(str1) + Integer.parseInt(str2));
//		System.out.println(Integer.parseInt("23.33")); // NumberFormatException
//		System.out.println(Integer.parseInt("-")); // NumberFormatException
		
		// ͨ����׽�쳣���� String �� ������ ת��Ϊ����
		// Ҳ������ parseDouble���� ��ȡ �� ���� Ϊ����
		/*int i;
		try {
			i = Integer.parseInt("-");
		} catch(NumberFormatException e) {
			i = 0;
		}
		System.out.println(i);*/
		
		// ------- DecimalFormat Start -------
		// ���ְٷֱȸ�ʽ
//		DecimalFormat df = new DecimalFormat("##0.00%");
//		double d = 0;
//		System.out.println(df.format(d));
//		double d = 0.0;
//		System.out.println(d==0.0);
		
//		DecimalFormat df = new DecimalFormat("###.##%"); // �˴� ��������
//		double d2 = 21231.12345;
//		System.out.println(df.format(d2));
//		df.applyPattern("##0");// �˴���������
//		double d3 = 234.54;
//		System.out.println(df.format(d3));
//		df.applyPattern("##0.##");// �˴���������
//		double d4 = 234.545;
//		System.out.println(df.format(d4));
		
//		int v1 = 3;
//		int v2 = 5;
//		System.out.println(v1%v2);
		
//		double d1 = 3.0;
//		double d2 = 3.0;
//		System.out.println(d1%d2 == 0);
		
		// �� ���� ������飬�����ܲ��ܰ���ֵ���ȥ
		// ��ֵ ������ ������
//		int[] arr1 = new int[5];
//		fillArr(arr1); // ���Խ����������
//		showArr(arr1);
		
		// Math.round ����Ϊ����
//		double d1 = 0.5;
//		System.out.println(Math.round(d1)); // 1
		
		// double ���͵ı�������ʹ��ֵΪ���ͣ����г�������ʱ������Ϊ double �ͼ���
//		double d3 = 4;
//		double d2 = d3/5;
//		System.out.println(d2);
		
//		List<String> list = new ArrayList<String>();
//		List<String> list = null; // java.lang.NullPointerException
//		MyUtils.print(list.isEmpty()); // true����listΪnullʱ������java.lang.NullPointerException
//		MyUtils.print(list.size()); // 0����listΪnullʱ������java.lang.NullPointerException
//		MyUtils.print((String)list.get(0)); // java.lang.IndexOutOfBoundsException
		
		Calendar cal11 = Calendar.getInstance();
		cal11.add(Calendar.DAY_OF_MONTH, -1);
		MyPrintUtils.print(sdf.format(cal11.getTime()));
		cal = Calendar.getInstance();
		MyPrintUtils.print(cal.get(Calendar.DAY_OF_MONTH));
		sdf.applyPattern("yyyy��MM��");
		MyPrintUtils.print(sdf.format(cal.getTime()));
	}
	
	private static void fillArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
	}
	private static void showArr(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
