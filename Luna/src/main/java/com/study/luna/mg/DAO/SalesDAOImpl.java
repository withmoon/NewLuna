package com.study.luna.mg.DAO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.SalesVO;

@Repository
public class SalesDAOImpl implements SalesDAO {

	@Autowired
	private SqlSession sqlSession;

	/*매출현황 DB데이터 가져오기*/
	@Override
	public List<SalesVO> SalesList(SalesVO vo) throws Exception {
		System.out.println("SalesList DAO 수행");
		return sqlSession.selectList("mgSalesDAO.SRead",vo);
	}
	
	/*매출현황 엑셀파일 DB 전체데이터 가져오기*/
/*	@Override
	public List<Object> getSales(Map<String, Object> searchMap) {
		System.out.println("SalesExcelBooks DAO 수행");
		return sqlSession.selectList("mgSalesDAO.SRead",searchMap);
	}
	매출현황 엑셀파일 조건문 리스트 가져오기
	@Override
	public List<Object> getSalesDetail(Map<String, Object> searchMap) {
		System.out.println("SalesExcelDetail DAO 수행");
		return SqlSession.selectList("managerDAO.selectBooks",searchMap);
		return null;
	}*/
	@Override
	public List<Object> getSales(SalesVO vo) {
		System.out.println("SalesExcel DAO 수행");
		return sqlSession.selectList("mgSalesDAO.SRead",vo);
	}

	
}
