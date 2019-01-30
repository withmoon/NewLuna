package com.study.luna.mg.DAO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.QBoardVO;

@Repository
public class BoardDAOImpl  implements BoardDAO{

	@Autowired
	private SqlSessionTemplate SqlSession;

	@Override
	public void insertBoard(QBoardVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QBoardVO> QboardList(QBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("QboardList DAO 수행처리 ");
		return SqlSession.selectList("managerDAO.QList",vo);
	}
	

}
