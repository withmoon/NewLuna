package com.study.luna.user.area.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.area.dao.GetSidoDAO;
@Repository
public class GetSidoDAOImpl implements GetSidoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<MemberCommand> getSido() {
		return sqlSession.selectList("memberDAO.getSido");
	}

}
