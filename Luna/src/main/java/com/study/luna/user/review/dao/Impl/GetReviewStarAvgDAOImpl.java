package com.study.luna.user.review.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.review.dao.GetReviewStarAvgDAO;
@Repository
public class GetReviewStarAvgDAOImpl implements GetReviewStarAvgDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public String getReviewStarAvg(int roomnum) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("reviewDAO.getReviewStarAvg",roomnum);
	}

}
