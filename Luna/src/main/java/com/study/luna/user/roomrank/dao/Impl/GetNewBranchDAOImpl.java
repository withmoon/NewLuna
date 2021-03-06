package com.study.luna.user.roomrank.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.roomrank.dao.GetNewBranchDAO;
@Repository
public class GetNewBranchDAOImpl implements GetNewBranchDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MemberCommand> getNewBranch() {
		return sqlSession.selectList("rankDAO.getNewBranch");
	}

}
