package com.study.luna.user.review.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.dao.UpReviewContentDAO;
@Repository
public class UpReviewContentDAOImpl implements UpReviewContentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void upReviewContent(RoomReviewDTO rrd) {
		sqlSession.update("reviewDAO.upReviewContent",rrd);
	}

}
