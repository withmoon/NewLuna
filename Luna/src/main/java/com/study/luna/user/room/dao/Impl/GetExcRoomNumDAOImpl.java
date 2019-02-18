package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.GetExcRoomNumDAO;

@Repository
public class GetExcRoomNumDAOImpl implements GetExcRoomNumDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin) {
		return sqlSession.selectList("roomDAO.getExcRoomNum", romin);
	}

}
