package com.study.luna.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

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

	@Override
	public List<String> AllMail(AdminManagerApproveVO vo) {
		return sqlsession.selectList("luna.admin.board.AllMail",vo);
	}
	

}
