package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.GetAllRoomInfoDAO;

@Repository
public class GetAllRoomInfoDAOImpl implements GetAllRoomInfoDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin) {
		return sqlSession.selectList("roomDAO.getAllRoomInfo",romin);
	}

}
