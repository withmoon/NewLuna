package com.study.luna.pub.member.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.GetAdminListDAO;
@Repository
public class GetAdminListDAOImpl implements GetAdminListDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MemberCommand> getAdminList() {
		return sqlSession.selectList("memberDAO.getAdminList");
	}

}
