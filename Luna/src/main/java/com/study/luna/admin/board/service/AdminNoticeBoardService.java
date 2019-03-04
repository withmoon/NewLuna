package com.study.luna.admin.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminNoticeBoardVO;


public interface AdminNoticeBoardService {

	public void noticeinsert(AdminNoticeBoardVO vo)throws Exception;
	
	public void noticedelete(int num)throws Exception;
	
	public void noticeupdate(AdminNoticeBoardVO vo)throws Exception;
	
	public AdminNoticeBoardVO noticeread(int num)throws Exception;

	/*user_inform*/
	public List<AdminNoticeBoardVO> noticeAll(int start, int end, HttpSession session); //공지사항목록
	public int countNotice(String title); //글 갯수
	public AdminNoticeBoardVO read(int num) throws Exception; //공지사항 상세보기
}
