package com.my.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.my.base.BaseTest;

public class TimerTest extends BaseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DateTime dt = new DateTime();
		info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt) + "����������ʱ�̣�");
		
		TimerTask r1 = new TimerTask() {
			public void run() {
				DateTime dt = new DateTime();
				info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt) + " task begin");
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				
				double j = 2;
				for(long i=0; i<2000000000L; i++) {
					j = j * j;
					if(j>1000000) j = 2;
				}
				
				DateTime dt2 = new DateTime();
				info.info(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").print(dt2) + " task end");
			}
		};
		
		Timer timer = new Timer();
		
		/*
		 * ��ʱִ������
		 * ָ����ʱִ��
		 */
//		timer.schedule(r1, 2000L);
		
		/*
		 * �״���ָ����ʱ��ִ��
		 * ֮��ָ���̶�����ִ��
		 * �� task����ִ��ʱ��ϳ�ʱ(����ָ������)����ôִ�е����ھ�û�����壬�´�ִ�еĿ�ʼʱ��Ϊ �ϴ�����ִ�еĽ���ʱ��
		 */
//		timer.schedule(r1, 1000, 3000);
		
		/*
		 * �״���ָ����ʱ��ִ��
		 * ֮��ָ���̶�����ִ��
		 */
		timer.scheduleAtFixedRate(r1, 1000, 3000);
		
	}

}
