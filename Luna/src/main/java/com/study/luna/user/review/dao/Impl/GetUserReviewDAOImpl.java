package com.study.luna.user.review.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.review.dao.GetUserReviewDAO;
@Repository
public class GetUserReviewDAOImpl implements GetUserReviewDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<String> getUserReview(String id) {
		return sqlSession.selectList("reviewDAO.getUserReview",id);
	}

}
