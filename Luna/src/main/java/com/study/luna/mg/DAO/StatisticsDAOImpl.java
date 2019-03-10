package com.study.luna.mg.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.model.StatisticsVO;

@Repository
public class StatisticsDAOImpl implements StatisticsDAO{
  
	@Autowired
	private SqlSession sqlSession;

	@Override //일별카운트
	public int count(String date1, String date2, String branchName) {
		System.out.println("count DAO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("branchName", branchName);
		return sqlSession.selectOne("mgSalesReserveDAO.count", map);
	}

	@Override //일별 리스트
	public List<StatisticsVO> SalesReserveList(int start, int end, String date1, String date2) {
		System.out.println("SalesReserveList DAO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("mgSalesReserveDAO.SalesReserveList",map);
	} 

	@Override //월별카운트
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

	
	@Override //엑셀리스트
	public List<SalesVO> excelList(String date1, String date2, String branchName, int count) {
		System.out.println("excelList DAO");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("branchName", branchName);
		map.put("count",count);
		return sqlSession.selectList("mgSalesReserveDAO.excelList", map);
	}
	
	
	
	
}
