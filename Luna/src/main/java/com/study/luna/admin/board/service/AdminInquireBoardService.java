package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminInquireBoardVO;

public interface AdminInquireBoardService {

	public List<AdminInquireBoardVO> inquireList()throws Exception;
	public void inquireinsert(AdminInquireBoardVO vo)throws Exception;
	public AdminInquireBoardVO inquireread(Integer seq)throws Exception;
}
