package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.dao.AdminEventBoardDAO;
import com.study.luna.admin.model.dao.AdminEventBoardDAOImpl;
import com.study.luna.admin.model.vo.AdminEventBoardVO;

@Service
public class AdminEventBoardServiceImpl implements AdminEventBoardService{
   
   @Inject
   AdminEventBoardDAO adminEventBoardDAO;
   @Autowired
   AdminEventBoardDAOImpl eventBoardImpl;
   
   @Override
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception{
      adminEventBoardDAO.insert(adminEventBoardVO);
   }

   
    @Override
    public List<AdminEventBoardVO> listAlls() throws Exception{
       return adminEventBoardDAO.listAlls();
    }


    /*user/event.jsp*/
    //진행이벤트목록
	@Override
   	public List<AdminEventBoardVO> eventAll(int start, int end, HttpSession session) {
       	return eventBoardImpl.eventAll(start, end);
   	}

   	//종료이벤트목록
   	@Override
   	public List<AdminEventBoardVO> eventEndAll(int start, int end, HttpSession session) {
   		return eventBoardImpl.eventEndAll(start, end);
   	}

	//이벤트글 갯수
	@Override
	public int count(ModelAndView mav) {
		return eventBoardImpl.count(mav);
	}

	//이벤트 상세보기
	@Override
	public AdminEventBoardVO read(int seq) throws Exception {
		return eventBoardImpl.read(seq);
	}
}