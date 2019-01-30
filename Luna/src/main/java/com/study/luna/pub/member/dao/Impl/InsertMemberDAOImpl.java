package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.InsertMemberDAO;

@Repository
public class InsertMemberDAOImpl implements InsertMemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertMember(MemberCommand memcom) {
		sqlSession.insert("memberDAO.insertMember",memcom);
	}

}
