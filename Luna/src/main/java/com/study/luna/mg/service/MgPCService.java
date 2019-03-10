package com.study.luna.mg.service;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.SalesVO;
 
public interface MgPCService {
	// 회원리스트 검색 페이징
	public List<SalesVO> SalesList(int start, int end, String keyword, String searchOption) throws Exception;
 
	// 게시글 카운트
	public int countArticle(String keyword);

	// 엑셀
	public List<Object> getExcelObject(Map<String, Object> paramMap);

	public List<Object> excelList(SalesVO vo);

	// 예약현황 
	public List<SalesVO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName);
	//예약현황 카운트
	public int ReserveCount(String searchOption, String keyword, String branchName);
	
	//환불리스트
	public List<SalesVO> mgRefund(int start, int end, String searchOption, String keyword, String branchName);
	//환불하기 리스트 카운트
	public int RefundCount(String searchOption, String keyword, String branchName);
	//환불 처리
	public void Refund(int seq, int roomnum, String reservdate);

	

	
	

	
	
}
