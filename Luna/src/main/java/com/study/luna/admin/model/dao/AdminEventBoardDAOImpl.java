package com.study.luna.admin.model.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.study.luna.admin.model.vo.AdminEventBoardVO;



@Repository
public class AdminEventBoardDAOImpl implements AdminEventBoardDAO{
   
   @Inject
      SqlSession sqlsession;
   
    @Override
      public void insert(AdminEventBoardVO adminEventBoardVO) throws Exception {
         // TODO Auto-generated method stub
         sqlsession.insert("luna.admin.board.insertEventBoard", adminEventBoardVO);

      }


     @Override
      public List<AdminEventBoardVO> listAlls() throws Exception {
         // TODO Auto-generated method stub
         return sqlsession.selectList("luna.admin.board.listAlls");
      }

   }