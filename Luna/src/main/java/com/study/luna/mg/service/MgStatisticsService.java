package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.StatisticsVO;

public interface MgStatisticsService {

	//게시글 카운트
	int countArticle(String searchOption, String keyword);
	//월매출 리스트
	List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword);

}
