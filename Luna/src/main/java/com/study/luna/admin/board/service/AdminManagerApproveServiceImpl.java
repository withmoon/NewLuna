package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminManagerApproveDAO;
import com.study.luna.admin.model.vo.AdminManagerApproveVO;

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
	@Override
	public List<String> AllMail(AdminManagerApproveVO vo) {
		return approveDAO.AllMail(vo);
	}

}
