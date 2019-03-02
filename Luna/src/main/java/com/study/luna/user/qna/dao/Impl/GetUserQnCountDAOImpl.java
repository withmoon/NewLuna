package com.study.luna.user.qna.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.qna.dao.GetUserQnCountDAO;
@Repository
public class GetUserQnCountDAOImpl implements GetUserQnCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getUserQnCount(String id) {
		return sqlSession.selectOne("mgQBoard.getUserQnCount",id);
	}

}
