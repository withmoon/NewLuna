package com.study.luna.admin.board.service;

import java.util.List;

import com.study.luna.admin.model.vo.AdminManagerApproveVO;

public interface AdminManagerApproveService {

public List<AdminManagerApproveVO> approveList()throws Exception;
public void approveupdate(AdminManagerApproveVO vo)throws Exception;
public void approvedelete(String id)throws Exception;
}
