package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminEventBoardDAO;
import com.study.luna.admin.model.vo.AdminEventBoardVO;

@Service
public class AdminEventBoardServiceImpl implements AdminEventBoardService{
   
   @Inject
   AdminEventBoardDAO adminEventBoardDAO;
   
   @Override
   public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception{
      adminEventBoardDAO.insert(adminEventBoardVO);
   }

   
    @Override
    public List<AdminEventBoardVO> listAlls() throws Exception{
       return adminEventBoardDAO.listAlls();
    }
}