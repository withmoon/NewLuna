package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminNoticeBoardVO;


public interface AdminNoticeBoardService {

	public void noticeinsert(AdminNoticeBoardVO vo)throws Exception;
	
	public void noticedelete(int num)throws Exception;
	
	public List<AdminNoticeBoardVO> noticeList()throws Exception;
	
	public void noticeupdate(AdminNoticeBoardVO vo)throws Exception;
	
	public AdminNoticeBoardVO noticeread(int num)throws Exception;

}
