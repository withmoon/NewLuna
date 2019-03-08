package com.study.luna.mg.service;

import java.util.Date;
import java.util.List;

import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.model.StatisticsVO;
 
public interface MgStatisticsService {

	//게시글 카운트
	int countArticle(String searchOption, String keyword);
	//일별 매출 리스트
	List<StatisticsVO> SalesReserveList(int start, int end, String date1, String date2);
	//기간별 카운트
	int count(String date1, String date2, String branchName);
	//월별 리스트
	List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword);
	//엑셀 리스트
	List<SalesVO> excelList(int count, String date1, String date2,String branchName);
	

} 
