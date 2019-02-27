package com.study.luna.user.review.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.review.dao.GetReviewCountDAO;
@Repository
public class GetReviewCountDAOImpl implements GetReviewCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getReviewCount(int roomnum) {
		return sqlSession.selectOne("reviewDAO.getReviewCount",roomnum);
	}

}
