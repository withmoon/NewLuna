package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminNoticeBoardDAO;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

@Service
public class AdminNoticeBoardServiceImpl implements AdminNoticeBoardService {

	@Inject
	AdminNoticeBoardDAO adminNoticeBoardDAO;
	
	
	@Override
	public void noticeinsert(AdminNoticeBoardVO vo) throws Exception {
		adminNoticeBoardDAO.noticeinsert(vo);
	}


	@Override
	public List<AdminNoticeBoardVO> noticeList() throws Exception {
		// TODO Auto-generated method stub
		return adminNoticeBoardDAO.noticeList();
	}


	@Override
	public void noticeupdate(AdminNoticeBoardVO vo) throws Exception {
		adminNoticeBoardDAO.noticeupdate(vo);
		
	}


	@Override
	public AdminNoticeBoardVO noticeread(int num) throws Exception {
		// TODO Auto-generated method stub
		return adminNoticeBoardDAO.noticeread(num);
	}


	@Override
	public void noticedelete(int num) throws Exception {
		// TODO Auto-generated method stub
		adminNoticeBoardDAO.noticedelete(num);
	}

}
