package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardDAO {

   public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception;

 //  public List<AdminQnABoardVO> adminqnaboard(AdminQnABoardVO adminQnABoardVO) throws Exception;

public List<AdminQnABoardVO> listAll() throws Exception;

 // upadate , delete 
}