package com.study.luna.mg.DAO;

import java.util.Date;
import java.util.List;

import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {

	//회원현황 
	public List<SalesVO> SalesList(int start, int end, String keyword, String searchOption) throws Exception;
	//테이블 카운트
	public int countArticle(String keyword);
 
	// 엑셀파일
	public List<Object> getSales(SalesVO vo);

	// 예약현황
	public List<SalesVO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName);
	//예약현황 카운트
	public int ReserveCount(String searchOption, String keyword, String branchName);
		
	//환불리스트
	public List<SalesVO> mgRefund(int start, int end, String searchOption, String keyword, String branchName);
	//환불현황 카운트
	public int RefundCount(String searchOption, String keyword, String branchName);
	//환불처리
	public void Refund(int seq, int roomnum, String reservdate);

	

	
	

}
