package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.UpStatusDAO;

@Repository
public class UpStatusDAOImpl implements UpStatusDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void upStatus(MemberCommand memcom) {
		sqlSession.update("memberDAO.upStatus", memcom);
	}

}
