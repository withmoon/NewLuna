package com.study.luna.mg.DAO;

import java.util.List;

import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.model.StatisticsVO;

public interface StatisticsDAO {
  
	// 월매출 일별 리스트
	List<StatisticsVO> SalesReserveList(int start, int end, String date1, String date2);
	// 월매출 월별 리스트
	List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword);

	// 월매출 글 카운트
	int countArticle(String searchOption, String keyword);
	//기간별 매출 카운트
	int count(String date1, String date2, String branchName);
	//엑셀 리시튼
	List<SalesVO> excelList(String date1, String date2, String branchName, int count);

} 
