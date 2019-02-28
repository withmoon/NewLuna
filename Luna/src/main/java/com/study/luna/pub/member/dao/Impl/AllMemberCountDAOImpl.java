package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.AllMemberCountDAO;
@Repository
public class AllMemberCountDAOImpl implements AllMemberCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer allMemberCount() {
		return sqlSession.selectOne("memberDAO.allMemberCount");
	}

}
