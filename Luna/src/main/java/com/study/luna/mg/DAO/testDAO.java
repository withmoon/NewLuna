package com.study.luna.mg.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.mg.model.testVO;
import com.study.luna.mg.util.SqlSessionFactoryBean;

@Repository
public class testDAO {
	@Autowired
	private SqlSession mybatis;
	
	public testDAO() {
		mybatis = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	
	public List<testVO> selectTest(testVO vo) {
		System.out.println("selectTest");
		
		return mybatis.selectList("testDAO.selectTest",vo);
		
	}
}
