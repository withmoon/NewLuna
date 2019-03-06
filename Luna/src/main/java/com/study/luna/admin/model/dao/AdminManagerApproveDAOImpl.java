package com.study.luna.admin.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AdminManagerApproveDAOImpl implements AdminManagerApproveDAO {

	@Inject
	SqlSession sqlsession;

	@Override
	public void approveupdate(String id){
			sqlsession.update("luna.admin.board.approveupdate", id);
	}

	@Override
	public void approvedelete(String id){
		sqlsession.delete("luna.admin.board.approvedelete",id);
		
	}
	

}
