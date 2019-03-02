package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.SalesDAO;
import com.study.luna.mg.DAO.SalesDAOImpl;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.SalesVO;

@Service
public class MgPCServiceImpl implements MgPCService {

	@Autowired
	private SalesDAO SalesDAO;
	
	/*매출현황 리스트 DB*/  
	@Override
	public List<SalesVO> SalesList(int start, int end, String keyword) throws Exception {
		System.out.println("SalesList 서비스");
		return SalesDAO.SalesList(start,end,keyword); 
	}
	@Override
	public int countArticle(String keyword) {
		System.out.println("countArticle 서비스");
		return SalesDAO.countArticle(keyword);
	}
	/*매출현황 엑셀*/
	@Override
	public List<Object> getExcelObject(Map<String, Object> searchMap) {
		return null;
		/*	System.out.println("SalesExcel 서비스");
		//컨트롤러에서 넘어온 target에 따라 dao 실행구분
		System.out.println("Mg_sales DB 엑셀");
		return SalesDAO.getSales(searchMap);
		
		if("Mg_sales") {//DB�̸�
			System.out.println("Mg_sales DB 엑셀");
			return SalesDAO.getSales(searchMap);
		}
		if(target.equals("booksDetail")) {
			System.out.println("Mg_sales DB엑셀 조건식");
			return SalesDAO.getSalesDetail(searchMap);
		}*/
	}
	@Override
	public List<Object> excelList(SalesVO vo) {
		System.out.println("SalesExcel 서비스");
		return SalesDAO.getSales(vo); 
	}
	@Override
	public List<SalesVO> mgReserveList(SalesVO vo) {
		System.out.println("mgReserveList 서비스");
		
		return SalesDAO.mgReserveList(vo);
	}
	//환불하기
	@Override
	public void mgReserve(QBoardVO vo) {
		System.out.println("mgReserve 서비스");
		SalesDAO.mgReserve(vo);
	}
}
