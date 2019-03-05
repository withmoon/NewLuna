package com.study.luna.mg.DAO;

import java.util.List;

import com.study.luna.mg.model.StatisticsVO;

public interface StatisticsDAO {
 
	// 월매출 일별 리스트
	List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword);
	// 월매출 월별 리스트
	List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword);

	// 월매출 글 카운트
	int countArticle(String searchOption, String keyword);

} 
