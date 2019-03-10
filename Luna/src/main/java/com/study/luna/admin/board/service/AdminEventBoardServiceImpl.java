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
   
   //이밴트 글쓰기
   /*최대 번호 가져오기*/
   @Override
   public Integer eventSeq() {
	   return eventBoardImpl.eventSeq();
   }
   /*이벤트 글 등록*/
   @Override
   public void eventwrite(AdminEventBoardVO eboardVO) {
	   eventBoardImpl.eventwrite(eboardVO);
   }
 	
   //이벤트 상세보기
   @Override
   public AdminEventBoardVO read(int seq) throws Exception {
	   return eventBoardImpl.read(seq);
   }
   @Override
	public Integer event_Seq() {
	   return eventBoardImpl.event_Seq();
	}

   //이벤트 수정
   @Override
   public void update(AdminEventBoardVO eboardVO) {
	   eventBoardImpl.update(eboardVO);
   }

    @Override
    public void delete(int seq) throws Exception {
       // TODO Auto-generated method stub
        adminEventBoardDAO.delete(seq);
    }

	

	

	
}