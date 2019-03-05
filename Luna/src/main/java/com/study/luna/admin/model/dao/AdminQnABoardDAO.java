package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminQnABoardVO;

public interface AdminQnABoardDAO {
	public List<AdminQnABoardVO> qnaAll(int start, int end); //질문목록
	public int countQnA(String subject); //질문갯수

    public void insert(AdminQnABoardVO adminQnABoardVO) throws Exception;
   
    public void delete(int num) throws Exception;



    public void update(AdminQnABoardVO vo) throws Exception;

    public AdminQnABoardVO read(int num) throws Exception;

    /*user_inform*/
    public AdminQnABoardVO qnaRead(int num) throws Exception; //질문 상세보기
}