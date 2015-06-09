package com.my.test3;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class T2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		/*try {
			System.out.println(sdf.format(sdf.parse("2012-2-1")));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		/*System.out.println(sdf.format(cal.getTime()));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf.format(cal.getTime()));
		cal.add(Calendar.MONTH, -1);
		System.out.println(sdf.format(cal.getTime()));
		Calendar cal1 = (Calendar)cal.clone();
		cal.add(Calendar.DAY_OF_MONTH, -15);
		System.out.println("cal:" + sdf.format(cal.getTime()));
		System.out.println("cal1:" + sdf.format(cal1.getTime()));
		
		cal.set(2012, 0, 1);
		System.out.println("cal:" + sdf.format(cal.getTime()));
		cal.add(Calendar.MONTH, -1);
		System.out.println("cal:" + sdf.format(cal.getTime()));
		cal.set(2012, 0, 1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println("cal:" + sdf.format(cal.getTime()));*/
		
		// 克隆一个日历，修改克隆出来的日历，原日历不会改变
		Calendar cal2 = (Calendar)cal.clone();
		cal2.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(cal.getTime().toString());
		System.out.println(cal2.getTime().toString());

	}

}
