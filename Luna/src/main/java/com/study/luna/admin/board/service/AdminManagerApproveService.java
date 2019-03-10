package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

public interface AdminManagerApproveService {
	public void approveupdate(String id);
	public void approvedelete(String id);
	public List<AdminManagerApproveVO> AllMail(String type);
}
