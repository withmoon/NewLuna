package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.CancleExpulmemberDAO;
@Repository
public class CancleExpulmemberDAOImpl implements CancleExpulmemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void cancleExpulmember(String id) {
		sqlSession.update("memberDAO.cancleExpulmember",id);
	}

}
