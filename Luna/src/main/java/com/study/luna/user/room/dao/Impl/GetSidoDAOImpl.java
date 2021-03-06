package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.room.dao.GetSidoDAO;
@Repository
public class GetSidoDAOImpl implements GetSidoDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<String> getSido() {
		return sqlSession.selectList("roomDAO.getSido");
	}

}
