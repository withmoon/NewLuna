package com.study.luna.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

@Repository
public class AdminNoticeBoardDAOImpl implements AdminNoticeBoardDAO {

	@Inject
	SqlSession sqlsession;

	@Override
	public void noticeinsert(AdminNoticeBoardVO vo) throws Exception {
		sqlsession.insert("luna.admin.board.noticeinsert", vo);
	}

	@Override
	public List<AdminNoticeBoardVO> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList("luna.admin.board.noticeList");
	}

	@Override
	public void noticeupdate(AdminNoticeBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update("luna.admin.board.noticeupdate",vo);
		
	}

	@Override
	public AdminNoticeBoardVO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("luna.admin.board.noticeread",num);
	}

	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		
		sqlsession.delete("luna.admin.board.noticedelete",num);
	}
	

}
