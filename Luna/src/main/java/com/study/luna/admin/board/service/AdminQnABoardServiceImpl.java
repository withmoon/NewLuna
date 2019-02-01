package com.study.luna.admin.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminQnABoardDAO;
import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Service
public class AdminQnABoardServiceImpl implements AdminQnABoardService {

   @Inject
   AdminQnABoardDAO adminQnABoardDAO;
   
   @Override
   public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception {
      adminQnABoardDAO.insert(adminQnABoardVO);
   }

}