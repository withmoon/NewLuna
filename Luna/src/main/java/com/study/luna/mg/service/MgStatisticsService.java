package com.study.luna.mg.service;

import java.util.List;

import com.study.luna.mg.model.StatisticsVO;

public interface MgStatisticsService {

	//�Խñ� ī��Ʈ
	int countArticle(String searchOption, String keyword);
	//������ ����Ʈ
	List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword);

}
