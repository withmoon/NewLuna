package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardService {
   public void insert(AdminQnABoardVO vo) throws Exception;

   public List<AdminQnABoardVO> listAll() throws Exception;

   public AdminQnABoardVO read(int num) throws Exception;

   public void update(AdminQnABoardVO vo) throws Exception;

   public void delete(int num) throws Exception;

}