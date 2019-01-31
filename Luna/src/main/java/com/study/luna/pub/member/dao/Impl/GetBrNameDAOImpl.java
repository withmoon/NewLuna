package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.GetBrNameDAO;
@Repository
public class GetBrNameDAOImpl implements GetBrNameDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public String getBrName(String id) {
		return sqlSession.selectOne("memberDAO.getBrName",id);
	}

}
