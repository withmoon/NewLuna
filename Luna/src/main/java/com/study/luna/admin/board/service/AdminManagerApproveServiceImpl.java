package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminManagerApproveDAO;
import com.study.luna.admin.model.vo.AdminManagerApproveVO;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;

@Service
public class AdminManagerApproveServiceImpl implements AdminManagerApproveService {

	@Inject
	AdminManagerApproveDAO approveDAO;

	@Override
	public void approveupdate(AdminManagerApproveVO vo) throws Exception {
		approveDAO.approveupdate(vo);

	}

	@Override
	public void approvedelete(String id) throws Exception {
		approveDAO.approvedelete(id);
		
	}

}
