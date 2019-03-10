package com.study.luna.admin.model.dao;

import java.util.List;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

public interface AdminManagerApproveDAO {
	public void approveupdate(String id);
	
	public void approvedelete(String id);

	public List<String> AllMail(AdminManagerApproveVO vo);
}
