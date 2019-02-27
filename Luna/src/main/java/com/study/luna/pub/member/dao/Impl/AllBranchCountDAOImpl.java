package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.AllBranchCountDAO;
@Repository
public class AllBranchCountDAOImpl implements AllBranchCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer allBranchCount() {
		return sqlSession.selectOne("memberDAO.allBranchCount");
	}

}
