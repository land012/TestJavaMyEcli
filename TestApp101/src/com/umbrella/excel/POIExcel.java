package com.umbrella.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		try {
			FileInputStream fis = new FileInputStream("D:\\_c_myEc9\\MyTest\\files\\excel1.xlsx");
//			Workbook wb = new HSSFWorkbook(new POIFSFileSystem(fis));
//			Workbook wb = WorkbookFactory.create(fis);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet shet = wb.getSheet("Sheet1");
			System.out.println(shet.getFirstRowNum());
			System.out.println(shet.getLastRowNum());
			int rows = shet.getLastRowNum(); // 最后一行有数据的行的行号
//			int rows = shet.getPhysicalNumberOfRows(); // 实际有数据的行数，即不计算空行
			
			DataFormatter df = new DataFormatter();
			df.addFormat("yyyy\\-MM\\-dd", new SimpleDateFormat());
			df.setDefaultNumberFormat(new DecimalFormat("0.0"));
			df.addFormat("0.0", new DecimalFormat());
//			df.addFormat("yyyy-MM-dd", new SimpleDateFormat());
			XSSFFormulaEvaluator xssfFE = new XSSFFormulaEvaluator(wb);
			
			String id = "";
			String name = "";
			for(int i=0; i<=rows; i++) {
				Row row = shet.getRow(i);
				if(row!=null) {
					Cell cell0 = row.getCell(0);
					Cell cell1 = row.getCell(1);
					id = POIExcelUtil.getCellValueAsString(cell0);
					name = POIExcelUtil.getCellValueAsString(cell1);
					
//					id = df.formatCellValue(cell0, xssfFE);
//					name = df.formatCellValue(cell1, xssfFE);
					
//					int cell0Type = -1;
//					int cell1Type = -1;
//					if(cell0 != null) {
//						cell0Type = cell0.getCellType();
//					}
//					if(cell1 != null) {
//						cell1Type = cell1.getCellType();
//					}
//					System.out.println(cell0Type + " -- " + cell1Type);
				} else {
					id = "";
					name = "";
				}
				System.out.println(id + " ------- " + name);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
