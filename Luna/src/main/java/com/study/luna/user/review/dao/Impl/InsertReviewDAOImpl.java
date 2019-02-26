package com.study.luna.user.review.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.dao.InsertReviewDAO;
@Repository
public class InsertReviewDAOImpl implements InsertReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertReview(RoomReviewDTO rrd) {
		sqlSession.insert("reviewDAO.insertReview",rrd);
	}

}
