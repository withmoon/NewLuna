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

	/*������Ȳ DB������ ��������*/
	@Override
	public List<SalesVO> SalesList(SalesVO vo) throws Exception {
		System.out.println("SalesList DAO ����");
		return sqlSession.selectList("mgSalesDAO.SRead",vo);
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

	
}
