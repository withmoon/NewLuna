package com.study.luna.user.keeproom.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.keeproom.dao.DeletekroomDAO;
@Repository
public class DeletekroomDAOImpl implements DeletekroomDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void deletekroom(KeepRoomDTO krd) {
		sqlSession.delete("keepRoomDAO.deletekroom",krd);
	}

}
