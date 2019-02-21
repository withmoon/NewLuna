package com.study.luna.admin.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Repository
public class AdminQnABoardDAOImpl implements AdminQnABoardDAO {

   @Inject
   SqlSession sqlsession;
   @Autowired
   SqlSessionTemplate SqlSession;

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

   /*user_inform*/
   //질문목록
   public List<AdminQnABoardVO> qnaAll(int start, int end) {
	   System.out.println("===> 질문 목록");
  	 
	   Map<String, Object> map = new HashMap<String, Object>();
	   map.put("start", start);
	   map.put("end", end);
  	 
	   return SqlSession.selectList("qnaBoardDAO.qnaAll", map);
   }

   //질문갯수
   public int countQnA(ModelAndView mav) {
	   return SqlSession.selectOne("qnaBoardDAO.countQnA", mav);
   }

   //질문 상세보기
   @Override
   public AdminQnABoardVO qnaRead(int num) throws Exception {
	   System.out.println("===> 질문 상세보기");
	   return SqlSession.selectOne("qnaBoardDAO.viewQnA", num);
   }
}