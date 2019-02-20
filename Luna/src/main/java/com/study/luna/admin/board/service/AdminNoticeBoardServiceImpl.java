package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.dao.AdminNoticeBoardDAO;
import com.study.luna.admin.model.dao.AdminNoticeBoardDAOImpl;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

@Service
public class AdminNoticeBoardServiceImpl implements AdminNoticeBoardService {

	@Inject
	AdminNoticeBoardDAO adminNoticeBoardDAO;
	@Autowired
	AdminNoticeBoardDAOImpl noticeBoardDAOImpl;
	
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

	/*user_inform*/
	//공지사항 이벤트 목록
	@Override
	public List<AdminNoticeBoardVO> noticeAll(int start, int end, HttpSession session) {
		return noticeBoardDAOImpl.noticeAll(start, end);
	}

	//글 갯수
	@Override
	public int countNotice(ModelAndView mav) {
		return noticeBoardDAOImpl.countNotice(mav);
	}

}
