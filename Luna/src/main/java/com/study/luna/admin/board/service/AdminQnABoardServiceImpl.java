package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.dao.AdminQnABoardDAO;
import com.study.luna.admin.model.dao.AdminQnABoardDAOImpl;
import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Service
public class AdminQnABoardServiceImpl implements AdminQnABoardService {

   @Inject
   AdminQnABoardDAO adminQnABoardDAO;
   @Autowired
   AdminQnABoardDAOImpl	qnaBoardDAOImpl;

   @Override
   public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception {
      adminQnABoardDAO.insert(adminQnABoardVO);
   }

   @Override
   public List<AdminQnABoardVO> listAll() throws Exception {
      // TODO Auto-generated method stub
      return adminQnABoardDAO.listAll();
   }

   @Override
   public AdminQnABoardVO read(int num) throws Exception {
      // TODO Auto-generated method stub
      return adminQnABoardDAO.read(num);
   }

   @Override
   public void update(AdminQnABoardVO vo) throws Exception {
      // TODO Auto-generated method stub
      adminQnABoardDAO.update(vo);
   }

   @Override
   public void delete(int num) throws Exception {
      // TODO Auto-generated method stub
      adminQnABoardDAO.delete(num);
   }

   /*user_inform*/
   //질문 목록
   @Override
   public List<AdminQnABoardVO> qnaAll(int start, int end, HttpSession session) {
	   return qnaBoardDAOImpl.qnaAll(start, end);
   }

   //질문갯수
   @Override
   public int countQnA(ModelAndView mav) {
	   return qnaBoardDAOImpl.countQnA(mav);
   }

   //질문상세보기
   @Override
   public AdminQnABoardVO qnaRead(int num) throws Exception {
	   return qnaBoardDAOImpl.qnaRead(num);
}
}