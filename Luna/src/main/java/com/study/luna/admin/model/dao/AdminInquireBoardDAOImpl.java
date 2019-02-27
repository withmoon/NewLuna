package com.study.luna.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminInquireBoardVO;

@Repository
public class AdminInquireBoardDAOImpl implements AdminInquireBoardDAO {

	@Inject
	SqlSession sqlsession;
	
	@Override
	public List<AdminInquireBoardVO> inquireList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList("luna.admin.board.inquireList");
	}

	@Override
	public void inquireinsert(AdminInquireBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update("luna.admin.board.inquireinsert",vo);
		
	}

	@Override
	public AdminInquireBoardVO inquireread(Integer seq) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("luna.admin.board.inquireread",seq);
	}

	@Override
	public void inquiredelete(Integer seq) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.delete("luna.admin.board.inquiredelete",seq);
		
	}
}
