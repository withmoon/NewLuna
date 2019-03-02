package com.study.luna.user.qna.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.qna.dao.UpUserQnaReadstDAO;
@Repository
public class UpUserQnaReadstDAOImpl implements UpUserQnaReadstDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void upUserQnaReadst(int seq) {
		sqlSession.update("mgQBoard.upUserQnaReadst",seq);
	}

}
