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
		// --------- 生成文件名 Start ---------
		DateTime dt = new DateTime();
		DateTimeFormatter dftr = DateTimeFormat.forPattern("yyyyMMddHHmmss");
		String fname = dftr.print(dt);
		info.info(fname);
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("0000");
		// 使用 static 的方式加缀，不同对象会使用同一个 seq，但一旦程序结束重启，seq 将回到初始
//		String fnamesuffix = df.format(seq);
//		seq ++;
		// 使用随机数的方式加后缀
		BigDecimal bd = new BigDecimal(Math.random());
		bd = bd.multiply(new BigDecimal(10000));
		String fnamesuffix = df.format(bd);
		if(fnamesuffix.length()>4) {
			fnamesuffix = fnamesuffix.substring(fnamesuffix.length()-4);
		}
		info.info(fnamesuffix);
		// --------- 生成文件名 End ---------
		
		File f = new File("D:\\temp\\" + fname + fnamesuffix + ".xls");
		//File f = new File("D:\\temp\\temp1\\temp2\\txt1.txt");
		
		// 创建路径
//		File path = f.getParentFile();
//		if(!path.exists()) {
//			info.info("路径不存在，创建路径！");
//			if(path.mkdirs()) {
//				info.info("创建路径成功：" + path.getAbsolutePath());
//			} else {
//				info.info("创建路径失败：" + path.getAbsolutePath());
//			}
//		} else {
//			info.info("路径已存在，不必创建。");
//		}
		// 如果文件存在，则删除
		if(f.exists()) {
			info.info("文件已存在，删除原文件！");
			if(f.delete()) {
				info.info("文件删除成功！");
			} else {
				info.info("文件删除失败！");
				System.exit(-1);
			}
		}
		// 创建文件
		info.info("创建文件："+f.getAbsolutePath());
		try {
			if(f.createNewFile()) {
				info.info("创建文件成功：" + f.getAbsolutePath());
			} else {
				info.info("创建文件失败：" + f.getAbsolutePath());
			}
		} catch (IOException e) {
			// 当路径不存在时，会抛出异常
			info.info("创建文件失败，创建文件时抛出异常：" + e.getMessage());
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
			// -------- 标题和表头 Start --------
			ws.mergeCells(0, 0, 3, 0); // 合并单元格 (起始列, 起始行, 终止列, 终止行)
			
			WritableCellFormat wcf = new WritableCellFormat();
			wcf.setAlignment(Alignment.CENTRE);
			WritableFont font = new WritableFont(WritableFont.TIMES);
			font.setBoldStyle(WritableFont.BOLD);
			wcf.setFont(font);
			Label label_title = new Label(0, 0, "名单", wcf);
			Label label1 = new Label(0, 1, "Name"); // 行，列，值
			Label label2 = new Label(1, 1, "Age");
			Label label3 = new Label(2, 1, "Gender");
			Label label4 = new Label(3, 1, "Address");
			ws.addCell(label_title);
			ws.addCell(label1);
			ws.addCell(label2);
			ws.addCell(label3);
			ws.addCell(label4);
			// -------- 标题和表头 End --------
			
			int i = 2; // 数据起始行数
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
