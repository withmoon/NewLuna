package com.study.luna.admin.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

@Repository
public class AdminManagerApproveDAOImpl implements AdminManagerApproveDAO {

	@Inject
	SqlSession sqlsession;

	@Override
	public void approveupdate(AdminManagerApproveVO vo) throws Exception {
	
			sqlsession.update("luna.admin.board.approveupdate", vo);
	}

	@Override
	public void approvedelete(String id) throws Exception {
		sqlsession.delete("luna.admin.board.approvedelete",id);
		
	}
	

}
