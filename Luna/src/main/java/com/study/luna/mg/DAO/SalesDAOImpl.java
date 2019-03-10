package com.study.luna.mg.DAO;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.SalesVO;
import com.sun.mail.iap.Literal;

@Repository
public class SalesDAOImpl implements SalesDAO {
 
 
	@Autowired
	private SqlSession sqlSession;
 
	/*회원현황 DB데이터 가져오기*/
	@Override
	public List<SalesVO> SalesList(int start, int end,String keyword,String searchOption) throws Exception {
		System.out.println("SalesList DAO 수행");
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("keyword", keyword);
		map.put("searchOption", searchOption);
		//#start #end  에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return sqlSession.selectList("mgSalesDAO.listAll",map);
	}
	
	@Override
	public int countArticle(String keyword) {
		System.out.println("countArticle DAO 수행");
		return sqlSession.selectOne("mgSalesDAO.countArticle",keyword);
	}
	
	//엑셀판매현황
	@Override
	public List<Object> getSales(SalesVO vo) {
		System.out.println("SalesExcel DAO 수행");
		/*return sqlSession.selectList("mgSalesDAO.SRead",vo);*/
		return null;
	}
	//예약현황
	@Override
	public List<SalesVO> mgReserveList(int start, int end, String searchOption, String keyword, String branchName) {
		System.out.println("mgReserveList DAO 수행");
		//검색옵션 , 키워드 맵에 저장
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return sqlSession.selectList("mgSalesDAO.ReserveList",map);
	}
	//환불 현황
	@Override
	public List<SalesVO> mgRefund(int start, int end, String searchOption, String keyword, String branchName) {
		System.out.println("mgRefund DAO 수행");
		//검색옵션 , 키워드 맵에 저장
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		//#start #end 에 입력될 값
		map.put("start",start);
		map.put("end", end);
		
		return sqlSession.selectList("mgSalesDAO.mgRefund",map);
	}
	//예약현황 카운트
	@Override
	public int ReserveCount(String searchOption, String keyword,String branchName) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		return sqlSession.selectOne("mgSalesDAO.ReserveCount", map);
	}
	//환불현황 카운트
	@Override
	public int RefundCount(String searchOption, String keyword, String branchName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("branchName", branchName);
		return sqlSession.selectOne("mgSalesDAO.RefundCount", map);
	}
	@Override
	public void Refund(int seq, int roomnum, String reservdate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("seq",seq); 
		map.put("roomnum",roomnum);
		map.put("reservdate",reservdate);
		System.out.println(seq);
		System.out.println(roomnum);
		System.out.println(reservdate);
		
		String reservtime= sqlSession.selectOne("mgSalesDAO.Refund",map);
		System.out.println(reservtime);
		
	}

	
	

	
}
