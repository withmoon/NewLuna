package com.study.luna.user.review.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.review.dao.GetReviewRankDAO;
@Repository
public class GetReviewRankDAOImpl implements GetReviewRankDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Integer> getReviewRank() {
		return sqlSession.selectList("reviewDAO.getReviewRank");
	}

}
