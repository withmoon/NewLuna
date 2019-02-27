package com.study.luna.mg.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.StatisticsVO;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<StatisticsVO> SalesReserveList(int start, int end, String searchOption, String keyword) {
		System.out.println("SalesReserveList DAO");
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectList("mgSalesReserveDAO.SalesReserveList");
	}

	@Override 
	public int countArticle(String searchOption, String keyword) {
		System.out.println("countArticle DAO");
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectOne("mgSalesReserveDAO.countArticle", map);
	}

	@Override 
	public List<StatisticsVO> SalesReservemonth(int start, int end, String searchOption, String keyword) {
		System.out.println("SalesReservemonth DAO");
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		return sqlSession.selectList("mgSalesReserveDAO.SalesReservemonth");
	}
	
	
	
	
}
