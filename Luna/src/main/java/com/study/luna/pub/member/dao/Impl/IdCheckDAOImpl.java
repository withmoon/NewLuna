package com.study.luna.pub.member.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.dao.IdCheckDAO;

@Repository
public class IdCheckDAOImpl implements IdCheckDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer idCheck(MemberCommand memcom) {	
		System.out.println("daoImpl 에서의 멤" +memcom.getId());
		
		return sqlSession.selectOne("memberDAO.idCheck", memcom);
	}

}
