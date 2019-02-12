package com.study.luna.admin.model.dao;

import java.util.List;

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

   @Override
   public List<AdminQnABoardVO> listAll() throws Exception {
      // TODO Auto-generated method stub
      return sqlsession.selectList("luna.admin.board.listAll");
   }

   @Override
   public AdminQnABoardVO read(int num) throws Exception {
      return  sqlsession.selectOne("luna.admin.board.read",num);

   }

   @Override
   public void update(AdminQnABoardVO vo) throws Exception {
      sqlsession.update("luna.admin.board.update",vo);
      
   }

   @Override
   public void delete(int num) throws Exception {
      sqlsession.delete("luna.admin.board.delete",num);
      
   }
}