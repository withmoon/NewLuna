package com.study.luna.pub.member.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.member.dao.GetBranchNameDAO;

@Repository
public class GetBranchNameDAOImpl implements GetBranchNameDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<String> branchList(String gugun) {
		return sqlSession.selectList("memberDAO.branchList", gugun);
	}

}
