package com.study.luna.admin.board.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminManagerApproveDAO;

@Service
public class AdminManagerApproveServiceImpl implements AdminManagerApproveService {

	@Inject
	AdminManagerApproveDAO approveDAO;

	@Override
	public void approveupdate(String id){
		approveDAO.approveupdate(id);

	}

	@Override
	public void approvedelete(String id){
		approveDAO.approvedelete(id);
		
	}

}
