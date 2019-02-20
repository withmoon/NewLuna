package com.study.luna.admin.model.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminEventBoardVO;


public interface AdminEventBoardDAO {

    public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception;//�ֱ�
    
    
   public List<AdminEventBoardVO> listAlls() throws Exception;//����Ʈ�ҷ�����
    
   public AdminEventBoardVO read1(int seq) throws Exception;
   //상세보기
      
      
      public void update(AdminEventBoardVO adminEventBoardVO) throws Exception;
   //수정
      
      
      
      public void delete(int seq) throws Exception;//삭제


   
   /*user/event.jsp*/
   public List<AdminEventBoardVO> eventAll(int start, int end); //진행 이벤트 목록
   public List<AdminEventBoardVO> eventEndAll(int start, int end); //마감이벤트 목록
   public int count(ModelAndView mav);
   public AdminEventBoardVO read(int seq) throws Exception; //이벤트 상세보기
}