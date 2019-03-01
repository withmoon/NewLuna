package com.study.luna.user.roomrank.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomRankDTO;
import com.study.luna.user.roomrank.dao.GetNewReviewDAO;
@Repository
public class GetNewReviewDAOImpl implements GetNewReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<RoomRankDTO> getNewReview() {
		return sqlSession.selectList("rankDAO.getNewReview");
	}

}
