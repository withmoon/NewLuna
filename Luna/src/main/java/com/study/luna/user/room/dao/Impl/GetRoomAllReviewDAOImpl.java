package com.study.luna.user.room.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.room.dao.GetRoomAllReviewDAO;
@Repository
public class GetRoomAllReviewDAOImpl implements GetRoomAllReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomReviewDTO> getRoomAllReview(int roomnum) {
		return sqlSession.selectList("roomDAO.getRoomAllReview",roomnum);
	}

}
