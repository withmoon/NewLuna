package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.InsertAdminDAO;
@Repository
public class InsertAdminDAOImpl implements InsertAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertAdmin(MemberCommand memcom) {
		sqlSession.insert("memberDAO.insertAdmin",memcom);
	}

}
