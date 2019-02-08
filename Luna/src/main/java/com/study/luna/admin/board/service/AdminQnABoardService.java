package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardService {
   public void insert(AdminQnABoardVO vo) throws Exception;

   public List<AdminQnABoardVO> listAll() throws Exception;

}