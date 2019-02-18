package com.study.luna.user.room.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.GetRoomScheduleDAO;
@Repository
public class GetRoomScheduleDAOImpl implements GetRoomScheduleDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public RoomInfoDTO getRoomSchedule(RoomInfoDTO romin) {
		return sqlSession.selectOne("roomDAO.getRoomSchedule", romin);
	}

}
