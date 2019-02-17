package com.study.luna.mg.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelDownload {
	
	private static HSSFWorkbook workbook;
	
	public static void main(String[] args) throws IOException {
		
		workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		for (int i = 0; i < 10; i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < 7; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(i+" Row, "+j+" Cell");
			}
		}
		
		File f = new File("C:\\myProject\\ExcelTemp.xls");
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
	}
}

