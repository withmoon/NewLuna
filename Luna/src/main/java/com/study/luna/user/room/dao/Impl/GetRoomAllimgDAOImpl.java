package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomFileDTO;
import com.study.luna.user.room.dao.GetRoomAllimgDAO;
@Repository
public class GetRoomAllimgDAOImpl implements GetRoomAllimgDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomFileDTO> getRoomAllimg(int roomnum) {
		return sqlSession.selectList("roomDAO.getRoomAllimg",roomnum);
	}

}
