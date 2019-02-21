package com.study.luna.mg.DAO;

import java.util.HashMap;
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

	/*������Ȳ DB������ ��������*/
	@Override
	public List<SalesVO> SalesList(int start, int end,String keyword) throws Exception {
		System.out.println("SalesList DAO ����");
		Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("keyword", keyword);
		//#start #end �� �Էµ� ��
		map.put("start",start);
		map.put("end", end);
		
		return sqlSession.selectList("mgSalesDAO.listAll",map);
	}
	@Override
	public int countArticle(String keyword) {
		System.out.println("countArticle DAO ����");
		return sqlSession.selectOne("mgSalesDAO.countArticle",keyword);
	}
	
	/*������Ȳ �������� DB ��ü������ ��������*/
/*	@Override
	public List<Object> getSales(Map<String, Object> searchMap) {
		System.out.println("SalesExcelBooks DAO ����");
		return sqlSession.selectList("mgSalesDAO.SRead",searchMap);
	}
	������Ȳ �������� ���ǹ� ����Ʈ ��������
	@Override
	public List<Object> getSalesDetail(Map<String, Object> searchMap) {
		System.out.println("SalesExcelDetail DAO ����");
		return SqlSession.selectList("managerDAO.selectBooks",searchMap);
		return null;
	}*/
	@Override
	public List<Object> getSales(SalesVO vo) {
		System.out.println("SalesExcel DAO ����");
		return sqlSession.selectList("mgSalesDAO.SRead",vo);
	}
	@Override
	public List<SalesVO> mgReserveList(SalesVO vo) {
		System.out.println("mgReserveList DAO ����");
		return sqlSession.selectList("mgSalesDAO.ReserveList",vo);
	}

	
}
