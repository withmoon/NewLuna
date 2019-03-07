package com.study.luna.mg.service;

import java.util.Date;
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
	public List<StatisticsVO> SalesReserveList(int start, int end, String date1, String date2) {
		System.out.println("일매출 리스트 서비스");
		return DAO.SalesReserveList(start,end,date1,date2);
	}

	@Override
	public List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword) {
		System.out.println("월매출 리스트 서비스");
		return DAO.SalesReservemonth(start,end,searchOption,keyword);
	}

	@Override
	public int count(String date1, String date2, String branchName) {
		System.out.println("count 서비스");
		return DAO.count(date1,date2,branchName);
	}

	@Override
	public List<StatisticsVO> excelList(int count, String date1, String date2,String branchName) {
		System.out.println("count 서비스");
		return DAO.excelList(date1,date2,branchName,count);
	}

}
