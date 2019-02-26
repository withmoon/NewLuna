package com.study.luna.user.alamandqa.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.alamandqa.dao.GetAlamCountDAO;
@Repository
public class GetAlamCountDAOImpl implements GetAlamCountDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer getAlamCount(String id) {
		return sqlSession.selectOne("alamDAO.getAlamCount",id);
	}

}
