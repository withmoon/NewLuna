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
	public List<SalesVO> SalesList(int start, int end, String keyword,String searchOption) throws Exception {
		System.out.println("SalesList 서비스");
		return SalesDAO.SalesList(start,end,keyword,searchOption); 
	}
	@Override
	public int countArticle(String keyword ) {
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
	
	
	//예약현황 리스트
	@Override
	public List<SalesVO> mgReserveList(int start, int end, String searchOption, String keyword,String branchName) {
		System.out.println("mgReserveList 서비스");
		return SalesDAO.mgReserveList(start,end, searchOption,keyword,branchName);
	}
	//예약현황 카운트
	@Override
	public int ReserveCount(String searchOption, String keyword, String branchName) {
		System.out.println("ReserveCount 서비스");
		return SalesDAO.ReserveCount(searchOption,keyword,branchName);
	}
	//환불하기
	@Override
	public List<SalesVO> mgRefund(int start, int end, String searchOption, String keyword, String branchName) {
		System.out.println("mgRefund 서비스");
		return SalesDAO.mgRefund(start,end, searchOption,keyword,branchName);
	}
	@Override //환불하기 리스트 카운트
	public int RefundCount(String searchOption, String keyword, String branchName) {
		System.out.println("RefundCount 서비스");
		return SalesDAO.RefundCount(searchOption,keyword,branchName);
	}
	
	
}
