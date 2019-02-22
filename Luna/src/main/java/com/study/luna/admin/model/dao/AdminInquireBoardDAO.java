package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminInquireBoardVO;

public interface AdminInquireBoardDAO {

	public List<AdminInquireBoardVO> inquireList()throws Exception;
	
	public void inquireinsert(AdminInquireBoardVO vo)throws Exception;
	
	public AdminInquireBoardVO inquireread(Integer seq)throws Exception;
}
