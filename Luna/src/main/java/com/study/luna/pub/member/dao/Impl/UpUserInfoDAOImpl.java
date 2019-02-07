package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.UpUserInfoDAO;

@Repository
public class UpUserInfoDAOImpl implements UpUserInfoDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void upUserInfo(MemberCommand memcom) {
		sqlSession.update("memberDAO.upMyPageInfo",memcom);
	}

}
