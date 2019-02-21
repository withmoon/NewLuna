package com.study.luna.admin.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardService {
   public void insert(AdminQnABoardVO vo) throws Exception;

   public List<AdminQnABoardVO> listAll() throws Exception;

   public AdminQnABoardVO read(int num) throws Exception;

   public void update(AdminQnABoardVO vo) throws Exception;

   public void delete(int num) throws Exception;

   /*user_inform*/
   public List<AdminQnABoardVO> qnaAll(int start, int end, HttpSession session); //질문목록
   public int countQnA(ModelAndView mav); //질문 갯수
   public AdminQnABoardVO qnaRead(int num) throws Exception; //질문 상세보기
}