package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardDAO {

   public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception;
   
   public void delete(int num) throws Exception;

   public List<AdminQnABoardVO> listAll() throws Exception;

   public void update(AdminQnABoardVO vo) throws Exception;

   public AdminQnABoardVO read(int num) throws Exception;

}