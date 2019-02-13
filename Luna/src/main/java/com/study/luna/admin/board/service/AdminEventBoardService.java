package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminEventBoardVO;

public interface AdminEventBoardService {
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception;//넣기
    
    
   public List<AdminEventBoardVO> listAlls() throws Exception;//리스트불러오기
}