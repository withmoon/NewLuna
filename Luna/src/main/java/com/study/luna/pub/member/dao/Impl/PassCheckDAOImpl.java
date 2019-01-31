package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.PassCheckDAO;
@Repository
public class PassCheckDAOImpl implements PassCheckDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public String getPass(String id) {
		return sqlSession.selectOne("memberDAO.getPass",id);
	}

}
