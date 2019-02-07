package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.GetMyPageInfoDAO;

@Repository
public class GetMyPageInfoDAOImpl implements GetMyPageInfoDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberCommand getMyPageInfo(MemberCommand memcom) {
		return (MemberCommand) sqlSession.selectOne("memberDAO.getMyPageInfo",memcom);
	}

}
