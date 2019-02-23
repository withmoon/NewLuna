package com.study.luna.user.keeproom.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.keeproom.dao.GetKeepStatusDAO;
@Repository
public class GetKeepStatusDAOImpl implements GetKeepStatusDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getKeepStatus(KeepRoomDTO krd) {
		return sqlSession.selectOne("keepRoomDAO.getKeepStatus",krd);
	}

}
