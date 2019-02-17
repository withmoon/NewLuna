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

//pdf로 배울땐 별거없었는데 뭘까
public class excelView extends AbstractExcelPOIView {
	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//파일변환 타겟 얻어오기
		String type = model.get("excelType").toString();
		
		if(type.equals("Mgsales")) {
			List<SalesVO> List = (List<SalesVO>) model.get("excelList");
			//시트생성
			Sheet sheet = workbook.createSheet(type);
			Row row = null;
			int rowCount = 0;
			int cellCount = 0;
			
			//제목셀 생성
			row = sheet.createRow(rowCount++);
			
			//컬럼명
			row.createCell(cellCount++).setCellValue("DATE");
			row.createCell(cellCount++).setCellValue("인원");
			row.createCell(cellCount++).setCellValue("예약건수");
			row.createCell(cellCount++).setCellValue("금액");
			row.createCell(cellCount++).setCellValue("부가음식");
			row.createCell(cellCount++).setCellValue("금액");
			row.createCell(cellCount++).setCellValue("총매출");
			
			
			 for (SalesVO vo : List) {
	                row = sheet.createRow(rowCount++);
	                cellCount = 0;
	                row.createCell(cellCount++).setCellValue(vo.getDate()); //데이터를 가져와 입력
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
