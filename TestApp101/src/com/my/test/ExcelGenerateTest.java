package com.my.test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import com.my.base.BaseTest;
import com.my.vo.User;

public class ExcelGenerateTest extends BaseTest {
	private static int seq = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// --------- �����ļ��� Start ---------
		DateTime dt = new DateTime();
		DateTimeFormatter dftr = DateTimeFormat.forPattern("yyyyMMddHHmmss");
		String fname = dftr.print(dt);
		info.info(fname);
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0000");
		// ʹ�� static �ķ�ʽ��׺����ͬ�����ʹ��ͬһ�� seq����һ���������������seq ���ص���ʼ
//		String fnamesuffix = df.format(seq);
//		seq ++;
		// ʹ��������ķ�ʽ�Ӻ�׺
		BigDecimal bd = new BigDecimal(Math.random());
		bd = bd.multiply(new BigDecimal(10000));
		String fnamesuffix = df.format(bd);
		if(fnamesuffix.length()>4) {
			fnamesuffix = fnamesuffix.substring(fnamesuffix.length()-4);
		}
		info.info(fnamesuffix);
		// --------- �����ļ��� End ---------
		
		File f = new File("D:\\temp\\" + fname + fnamesuffix + ".xls");
		//File f = new File("D:\\temp\\temp1\\temp2\\txt1.txt");
		
		// ����·��
//		File path = f.getParentFile();
//		if(!path.exists()) {
//			info.info("·�������ڣ�����·����");
//			if(path.mkdirs()) {
//				info.info("����·���ɹ���" + path.getAbsolutePath());
//			} else {
//				info.info("����·��ʧ�ܣ�" + path.getAbsolutePath());
//			}
//		} else {
//			info.info("·���Ѵ��ڣ����ش�����");
//		}
		// ����ļ����ڣ���ɾ��
		if(f.exists()) {
			info.info("�ļ��Ѵ��ڣ�ɾ��ԭ�ļ���");
			if(f.delete()) {
				info.info("�ļ�ɾ���ɹ���");
			} else {
				info.info("�ļ�ɾ��ʧ�ܣ�");
				System.exit(-1);
			}
		}
		// �����ļ�
		info.info("�����ļ���"+f.getAbsolutePath());
		try {
			if(f.createNewFile()) {
				info.info("�����ļ��ɹ���" + f.getAbsolutePath());
			} else {
				info.info("�����ļ�ʧ�ܣ�" + f.getAbsolutePath());
			}
		} catch (IOException e) {
			// ��·��������ʱ�����׳��쳣
			info.info("�����ļ�ʧ�ܣ������ļ�ʱ�׳��쳣��" + e.getMessage());
			System.exit(-1);
		}
		
		List<User> userList = new ArrayList<User>();
		User u1 = new User();
		u1.setName("Tom");
		u1.setAge("20");
		u1.setGender("male");
		u1.setAddress("BeiJing");
		User u2 = new User();
		u2.setName("Liy");
		u2.setAge("22");
		u2.setGender("female");
		u2.setAddress("San Francisco");
		User u3 = new User();
		u3.setName("Jim");
		u3.setAge("21");
		u3.setGender("male");
		u3.setAddress("Los Angeles");
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		
		try {
			WritableWorkbook wwb = Workbook.createWorkbook(f);
			WritableSheet ws = wwb.createSheet("Sheet001", 0);
			// -------- ����ͱ�ͷ Start --------
			ws.mergeCells(0, 0, 3, 0); // �ϲ���Ԫ�� (��ʼ��, ��ʼ��, ��ֹ��, ��ֹ��)
			
			WritableCellFormat wcf = new WritableCellFormat();
			wcf.setAlignment(Alignment.CENTRE);
			WritableFont font = new WritableFont(WritableFont.TIMES);
			font.setBoldStyle(WritableFont.BOLD);
			wcf.setFont(font);
			Label label_title = new Label(0, 0, "����", wcf);
			Label label1 = new Label(0, 1, "Name"); // �У��У�ֵ
			Label label2 = new Label(1, 1, "Age");
			Label label3 = new Label(2, 1, "Gender");
			Label label4 = new Label(3, 1, "Address");
			ws.addCell(label_title);
			ws.addCell(label1);
			ws.addCell(label2);
			ws.addCell(label3);
			ws.addCell(label4);
			// -------- ����ͱ�ͷ End --------
			
			int i = 2; // ������ʼ����
			Iterator<User> it = userList.iterator();
			while(it.hasNext()) {
				User u =  it.next();
				Label l1 = new Label(0, i, u.getName());
				Label l2 = new Label(1, i, u.getAge());
				Label l3 = new Label(2, i, u.getGender());
				Label l4 = new Label(3, i, u.getAddress());
				ws.addCell(l1);
				ws.addCell(l2);
				ws.addCell(l3);
				ws.addCell(l4);
				i++;
			}
//			for(User u : userList) {
//				Label l1 = new Label(0, i, u.getName());
//				
//			}
			wwb.write();
			wwb.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}

}
