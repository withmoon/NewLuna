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

 	//진행이벤트글 갯수
 	@Override
 	public int countEvent(String title) {
 		return eventBoardImpl.countEvent(title);
 	}
 	
 	//종료이벤트글 갯수
 	@Override
 	public int countEventEnd(String title) {
 		return eventBoardImpl.countEventEnd(title);
 	}
   
   @Override
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception{
      adminEventBoardDAO.insert(adminEventBoardVO);
   }
    
    @Override
    public AdminEventBoardVO read1(int seq) throws Exception {
       return adminEventBoardDAO.read(seq);
    }

    @Override
    public void update(AdminEventBoardVO adminEventBoardVO) throws Exception {
       // TODO Auto-generated method stub
        adminEventBoardDAO.update(adminEventBoardVO);
    }

    @Override
    public void delete(int seq) throws Exception {
       // TODO Auto-generated method stub
        adminEventBoardDAO.delete(seq);
    }

    /*user/event.jsp*/
    //이벤트 상세보기
	@Override
	public AdminEventBoardVO read(int seq) throws Exception {
		return eventBoardImpl.read(seq);
	}
}