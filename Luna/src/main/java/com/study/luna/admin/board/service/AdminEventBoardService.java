package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminEventBoardVO;

public interface AdminEventBoardService {
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception;//�ֱ�
    
    
   public List<AdminEventBoardVO> listAlls() throws Exception;//����Ʈ�ҷ�����
   
   /*user/event.jsp*/
   public List<AdminEventBoardVO> eventList(AdminEventBoardVO ebVO); //진행이벤트 목록
   public List<AdminEventBoardVO> eventEndList(AdminEventBoardVO ebVO); //마감이벤트 목록
   public AdminEventBoardVO read(int seq) throws Exception; //이벤트  상세보기
}