package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.SalesVO;

public interface SalesDAO {

	//회원현황
	public List<SalesVO> SalesList(int start, int end, String keyword, String searchOption) throws Exception;
	 
	// 테이블 카운트
	public int countArticle(String keyword);

	// 엑셀파일
	public List<Object> getSales(SalesVO vo);

	// 예약현황
	public List<SalesVO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName);
	//예약현황 카운트
	public int ReserveCount(String searchOption, String keyword, String branchName);
		
	//환불하기
	public void mgReserve(QBoardVO vo);

	
	

}
