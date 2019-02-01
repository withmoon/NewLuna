package com.study.luna.admin.model.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Repository
public class AdminQnABoardDAOImpl implements AdminQnABoardDAO {

   @Inject
   SqlSession sqlsession;

   @Override
   public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception {
      // TODO Auto-generated method stub
      sqlsession.insert("luna.admin.board.insertQnABoard", adminQnABoardVO);

   }

}