package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminEventBoardVO;


public interface AdminEventBoardDAO {

    public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception;//넣기
    
    
   public List<AdminEventBoardVO> listAlls() throws Exception;//리스트불러오기
    
    //상세보기
    //수정
    //삭제
}