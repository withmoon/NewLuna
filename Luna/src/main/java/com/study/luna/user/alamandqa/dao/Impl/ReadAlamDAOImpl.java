package com.study.luna.user.alamandqa.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.alamandqa.dao.ReadAlamDAO;
import com.study.luna.user.dto.AlamDTO;

@Repository
public class ReadAlamDAOImpl implements ReadAlamDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void readAlam(AlamDTO ald) {
		sqlSession.update("alamDAO.readAlam",ald);
	}

}
