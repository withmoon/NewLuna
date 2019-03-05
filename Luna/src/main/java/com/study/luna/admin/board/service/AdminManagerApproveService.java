package com.study.luna.admin.board.service;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

public interface AdminManagerApproveService {
	public void approveupdate(AdminManagerApproveVO vo)throws Exception;
	public void approvedelete(String id)throws Exception;
}
