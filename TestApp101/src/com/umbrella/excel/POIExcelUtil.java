package com.umbrella.excel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

public class POIExcelUtil {
	
	/**
	 * 获取 Cell 的内容
	 * @param cell
	 * @return
	 */
	public static String getCellValueAsString(Cell cell) {
		if(cell != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DecimalFormat df = new DecimalFormat("#.#");
			int cellType = cell.getCellType();
			switch(cellType) {
				case Cell.CELL_TYPE_BLANK:
					return cell.getStringCellValue();
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				case Cell.CELL_TYPE_ERROR:
					return String.valueOf(cell.getErrorCellValue());
				case Cell.CELL_TYPE_FORMULA:
					return getCellValueByCellType(cell, cell.getCachedFormulaResultType());
				case Cell.CELL_TYPE_NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						return sdf.format(cell.getDateCellValue());
					} else {
						return df.format(cell.getNumericCellValue());
					}
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
			}
		}
		return "";
	}
	
	private static String getCellValueByCellType(Cell cell, int cellType) {
		if(cell != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DecimalFormat df = new DecimalFormat("#");
			switch(cellType) {
				case Cell.CELL_TYPE_BLANK:
					return cell.getStringCellValue();
				case Cell.CELL_TYPE_BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());
				case Cell.CELL_TYPE_ERROR:
					return String.valueOf(cell.getErrorCellValue());
				case Cell.CELL_TYPE_NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						return sdf.format(cell.getDateCellValue());
					} else {
						return df.format(cell.getNumericCellValue());
					}
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
			}
		}
		return "";
	}




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
