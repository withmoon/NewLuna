package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.DnStatusDAO;

@Repository
public class DnStatusDAOImpl implements DnStatusDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void dnStatus(MemberCommand memcom) {
		sqlSession.update("memberDAO.dnStatus",memcom);
	}

}
