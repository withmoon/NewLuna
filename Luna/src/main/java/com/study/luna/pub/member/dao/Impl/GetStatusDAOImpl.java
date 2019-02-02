package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.GetStatusDAO;

@Repository
public class GetStatusDAOImpl implements GetStatusDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int getStatus(MemberCommand memcom) {
		return sqlSession.selectOne("memberDAO.getStatus",memcom);
	}

}
