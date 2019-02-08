package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.room.dao.GetGugunDAO;

@Repository
public class GetGugunDAOImpl implements GetGugunDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<String> getGugun(String sido) {
		System.out.println("디에오에서 받은 시도==>"+sido);
		return sqlSession.selectList("roomDAO.getGugun",sido);
	}

}
