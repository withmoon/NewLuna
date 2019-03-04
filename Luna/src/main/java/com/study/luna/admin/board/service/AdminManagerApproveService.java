package com.study.luna.admin.board.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

public interface AdminManagerApproveService {
	public List<AdminManagerApproveVO> approveList()throws Exception;
	public void approveupdate(AdminManagerApproveVO vo)throws Exception;
	public void approvedelete(String id)throws Exception;
}
