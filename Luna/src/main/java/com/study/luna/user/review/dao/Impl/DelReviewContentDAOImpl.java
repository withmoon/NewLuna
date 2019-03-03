package com.study.luna.user.review.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.dao.DelReviewContentDAO;
@Repository
public class DelReviewContentDAOImpl implements DelReviewContentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void delReviewContent(RoomReviewDTO rrd) {
		sqlSession.delete("reviewDAO.delReviewContent",rrd);
	}

}
