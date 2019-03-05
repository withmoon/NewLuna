package com.study.luna.admin.model.dao;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;


public interface AdminManagerApproveDAO {
	public void approveupdate(AdminManagerApproveVO vo)throws Exception;
	
	public void approvedelete(String id)throws Exception;
}
