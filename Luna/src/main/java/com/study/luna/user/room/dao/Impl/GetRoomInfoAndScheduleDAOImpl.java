package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.GetRoomInfoAndScheduleDAO;
@Repository
public class GetRoomInfoAndScheduleDAOImpl implements GetRoomInfoAndScheduleDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<RoomInfoDTO> getRoomInfoAndSchedule(RoomInfoDTO romin) {
		return sqlSession.selectList("roomDAO.getRoomInfoAndSchedule", romin);
	}

}
