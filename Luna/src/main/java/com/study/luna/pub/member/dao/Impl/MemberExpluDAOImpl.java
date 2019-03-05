package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.MemberExpluDAO;

@Repository
public class MemberExpluDAOImpl implements MemberExpluDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void expulmember(String id) {
		sqlSession.update("memberDAO.expulmember",id);
	}

}
