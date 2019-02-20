package com.study.luna.admin.model.dao;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.model.vo.AdminNoticeBoardVO;


public interface AdminNoticeBoardDAO {

	public void noticeinsert(AdminNoticeBoardVO vo) throws Exception;

	public void noticeupdate(AdminNoticeBoardVO vo)throws Exception;
	
	public void noticedelete(int num)throws Exception;
	
	public AdminNoticeBoardVO noticeread(int num) throws Exception;
	
	public List<AdminNoticeBoardVO> noticeList() throws Exception;

	/*user_inform*/
	public List<AdminNoticeBoardVO> noticeAll(int start, int end); //공지사항목록
	public int countNotice(ModelAndView mav); //글 갯수
}
