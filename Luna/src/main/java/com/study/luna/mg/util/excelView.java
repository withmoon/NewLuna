package com.study.luna.mg.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.study.luna.mg.model.SalesVO;

//pdf�� ��ﶩ ���ž����µ� ����
public class excelView extends AbstractExcelPOIView {
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//���Ϻ�ȯ Ÿ�� ������
		String type = model.get("excelType").toString();
		
		if(type.equals("Mgsales")) {
			List<SalesVO> List = (List<SalesVO>) model.get("excelList");
			//��Ʈ����
			Sheet sheet = workbook.createSheet(type);
			Row row = null;
			int rowCount = 0;
			int cellCount = 0;
			
			//���� ����
			row = sheet.createRow(rowCount++);
			
			//�÷���
			row.createCell(cellCount++).setCellValue("DATE");
			row.createCell(cellCount++).setCellValue("�ο�");
			row.createCell(cellCount++).setCellValue("����Ǽ�");
			row.createCell(cellCount++).setCellValue("�ݾ�");
			row.createCell(cellCount++).setCellValue("�ΰ�����");
			row.createCell(cellCount++).setCellValue("�ݾ�");
			row.createCell(cellCount++).setCellValue("�Ѹ���");
			
			
			 for (SalesVO vo : List) {
	                row = sheet.createRow(rowCount++);
	                cellCount = 0;
	                row.createCell(cellCount++).setCellValue(vo.getDate()); //�����͸� ������ �Է�
	                row.createCell(cellCount++).setCellValue(vo.getInone());
	                row.createCell(cellCount++).setCellValue(vo.getSu());
	                row.createCell(cellCount++).setCellValue(vo.getSales1());
	                row.createCell(cellCount++).setCellValue(vo.getMarket());
	                row.createCell(cellCount++).setCellValue(vo.getSales2());
	                row.createCell(cellCount++).setCellValue(vo.getTotal());
			 }
		}
	
	}
	@Override
	protected Workbook createWorkbook() {
		return new SXSSFWorkbook();
	}
}
