package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminEventBoardVO;


public interface AdminEventBoardDAO {
	public List<AdminEventBoardVO> eventAll(int start, int end); //진행 이벤트 목록
	public List<AdminEventBoardVO> eventEndAll(int start, int end); //마감이벤트 목록
	public int countEvent(String title); //진행count
	public int countEventEnd(String title); //마감count
	
	//이벤트 글쓰기
	public Integer eventSeq(); //최대 번호 가져오기
	public void eventwrite(AdminEventBoardVO eboardVO); //이벤트 글 등록
	
    
    
   public AdminEventBoardVO read1(int seq) throws Exception;
   //상세보기
      
      
      public void update(AdminEventBoardVO adminEventBoardVO) throws Exception;
   //수정
      
      
      
      public void delete(int seq) throws Exception;//삭제


   
   /*user/event.jsp*/
   public AdminEventBoardVO read(int seq) throws Exception; //이벤트 상세보기
}