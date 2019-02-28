package com.study.luna.mg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.mg.DAO.StatisticsDAO;
import com.study.luna.mg.model.StatisticsVO;

@Service
public class MgStatisticsServiceImpl implements MgStatisticsService{
	
	@Autowired
	private StatisticsDAO DAO;
	
	@Override
	public int countArticle(String searchOption, String keyword) {
		System.out.println("월매출 카운트 서비스");
		return DAO.countArticle(searchOption,keyword);
	}

	@Override
	public List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword) {
		System.out.println("일매출 리스트 서비스");
		return DAO.SalesReserveList(start,end,searchOption,keyword);
	}

	@Override
	public List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword) {
		System.out.println("월매출 리스트 서비스");
		return DAO.SalesReservemonth(start,end,searchOption,keyword);
	}

}
