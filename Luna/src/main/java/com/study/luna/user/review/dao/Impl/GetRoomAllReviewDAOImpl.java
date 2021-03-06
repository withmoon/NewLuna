package com.study.luna.user.review.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.dao.GetRoomAllReviewDAO;
@Repository
public class GetRoomAllReviewDAOImpl implements GetRoomAllReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<RoomReviewDTO> getRoomAllReview(int start,int end,int roomnum) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("roomNum", roomnum);
		map.put("start",start);
		map.put("end", end);
		return sqlSession.selectList("reviewDAO.getRoomAllReview",map);
	}

}
