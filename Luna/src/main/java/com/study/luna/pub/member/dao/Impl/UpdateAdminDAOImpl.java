package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.UpdateAdminDAO;
@Repository
public class UpdateAdminDAOImpl implements UpdateAdminDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void updateAdmin(MemberCommand memcom) {
		sqlSession.update("memberDAO.updateAdmin",memcom);
	}

}
