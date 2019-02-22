package com.study.luna.mg.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.study.luna.mg.model.SalesVO;

public class listExcelDownload extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> modelMap, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 String sCurTime = null;
	        sCurTime = new SimpleDateFormat("yyyyMMdd", Locale.KOREA).format(new Date());
	     
	        String excelName = sCurTime + "_���ÿ����ٿ�ε�.xlsx";
	        Sheet worksheet = null;
	        Row row = null;
	        CellStyle style = workbook.createCellStyle(); // �� ��Ÿ���� ���� ����
	       // style.setAlignment(CellStyle.ALIGN_CENTER); // �� ��ġ�� �߾����� ����
	         
	        List<SalesVO> listExcel = (List<SalesVO>) modelMap.get("list");
	         
	        // ���ο� sheet�� �����Ѵ�.
	        worksheet = workbook.createSheet("���� ���");
	         
	        // ���� ù��° �ٿ� ������ �����.
	        row = worksheet.createRow(0);
	         
	        // Į�� ���� ����
	        int columnIndex = 0;
	        while (columnIndex < 7) {
	             
	            if(columnIndex == 0) {
	                worksheet.setColumnWidth(columnIndex, 3000);
	            } else if (columnIndex == 1) {
	                worksheet.setColumnWidth(columnIndex, 4000);
	            } else if (columnIndex == 2) {
	                worksheet.setColumnWidth(columnIndex, 6000);
	            } else if (columnIndex == 3) {
	                worksheet.setColumnWidth(columnIndex, 4000);
	            } else if (columnIndex == 4) {
	                worksheet.setColumnWidth(columnIndex, 7000);
	            } else if (columnIndex == 5) {
	                worksheet.setColumnWidth(columnIndex, 3000);
	            } else if (columnIndex == 6) {
	                worksheet.setColumnWidth(columnIndex, 3000);
	            }
	            columnIndex++;
	        }
	         
	        // ��� ����
	        row = worksheet.createRow(0);
	        row.createCell(0).setCellValue("ID");
	        row.createCell(1).setCellValue("����");
	        row.createCell(2).setCellValue("����");
	        row.createCell(3).setCellValue("�ۼ���");
//	        row.createCell(4).setCellValue("����Ͻ�");
	        row.createCell(5).setCellValue("��ȸ ��");
	        row.createCell(6).setCellValue("��� ��");
	         
	        int rowIndex = 1;
	         
	        // �� �ش��ϴ� ���� ���� ��Ÿ���� ����
	        for(SalesVO board: listExcel) {
	            row = worksheet.createRow(rowIndex);
	            row.createCell(0).setCellValue(board.getImp_uid());
	            row.createCell(1).setCellValue(board.getBranchname());
	            row.createCell(2).setCellValue(board.getRoomnum());
	            row.createCell(3).setCellValue(board.getMarket());
//	            row.createCell(4).setCellValue(board.getDate().toLocaleString());
	            row.createCell(5).setCellValue(board.getSeq());
	            row.createCell(6).setCellValue(board.getRoomnum());
	             
	            rowIndex++;
	        }
	         
	        // �� ���� CellRangeAddress(���� ��, �� ��, ���� ��, �� ��)
	        worksheet.addMergedRegion(
	                new CellRangeAddress(listExcel.size() + 1, listExcel.size() + 1, 0, 6));
	         
	        // ���� �׽�Ʈ�� ���� ����
	        row = worksheet.createRow(listExcel.size() + 1);
	        row.createCell(0).setCellValue("�� ���� �׽�Ʈ");
	        row.getCell(0).setCellStyle(style); // ������ ��Ÿ���� �����ش�.
	         
	         
	        try {
	            response.setHeader("Content-Disposition", "attachement; filename=\""
	                + java.net.URLEncoder.encode(excelName, "UTF-8") + "\";charset=\"UTF-8\"");
	          } catch (UnsupportedEncodingException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	          }

	}

}
