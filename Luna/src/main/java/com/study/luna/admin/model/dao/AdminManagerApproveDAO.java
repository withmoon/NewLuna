package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;


public interface AdminManagerApproveDAO {

	public List<AdminManagerApproveVO> approveList() throws Exception;
	
	public void approveupdate(AdminManagerApproveVO vo)throws Exception;
	
	public void approvedelete(String id)throws Exception;
}
