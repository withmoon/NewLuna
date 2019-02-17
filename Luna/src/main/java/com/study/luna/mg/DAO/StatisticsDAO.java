package com.study.luna.mg.DAO;

import java.util.List;

import com.study.luna.mg.model.StatisticsVO;

public interface StatisticsDAO {

	//������ ����Ʈ
	List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword);

	//������ �� ī��Ʈ
	int countArticle(String searchOption, String keyword);

}
