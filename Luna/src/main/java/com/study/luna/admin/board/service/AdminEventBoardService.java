package com.study.luna.admin.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminEventBoardVO;
import com.study.luna.user.comment.vo.EventReplyVO;

public interface AdminEventBoardService {
	public List<AdminEventBoardVO> eventAll(int start, int end, HttpSession session); //진행 이벤트 목록
	public List<AdminEventBoardVO> eventEndAll(int start, int end, HttpSession session); //마감이벤트 목록
	public int countEvent(String title); //진행이벤트글 갯수 (페이징)
	public int countEventEnd(String title); //마감이벤트글 갯수 (페이징)
	
	//이벤트 글쓰기
	public Integer eventSeq(); //최대 번호 가져오기
	public void eventwrite(AdminEventBoardVO eboardVO); //이벤트 글 등록
	
	public AdminEventBoardVO read(int seq) throws Exception; //이벤트 상세보기
	public void update(AdminEventBoardVO eboardVO);//이벤트수정

   public void delete(int seq) throws Exception;//삭제

   /*user/event.jsp*/
   
   

}