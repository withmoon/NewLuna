package com.study.luna.user.room.dao.Impl;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.GetDetailRoomInfoDAO;

@Repository
public class GetDetailRoomInfoDAOImpl implements GetDetailRoomInfoDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	@Override
	public RoomInfoDTO getDetailRoomInfo(RoomInfoDTO romin) {
		return sqlSession.selectOne("roomDAO.getDetailRoomInfo",romin);
	}

}
