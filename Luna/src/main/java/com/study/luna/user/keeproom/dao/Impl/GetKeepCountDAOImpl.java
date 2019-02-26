package com.study.luna.user.keeproom.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.keeproom.dao.GetKeepCountDAO;
@Repository
public class GetKeepCountDAOImpl implements GetKeepCountDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer getKeepCount(String id) {
		return sqlSession.selectOne("keepRoomDAO.getKeepCount",id);
	}

}
