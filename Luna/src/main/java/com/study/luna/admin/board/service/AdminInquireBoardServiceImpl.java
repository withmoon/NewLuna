package com.study.luna.admin.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.study.luna.admin.model.dao.AdminInquireBoardDAO;
import com.study.luna.admin.model.vo.AdminInquireBoardVO;

@Service
public class AdminInquireBoardServiceImpl implements AdminInquireBoardService {

	@Inject
	AdminInquireBoardDAO adminDAO;
	
	@Override
	public List<AdminInquireBoardVO> inquireList() throws Exception {
		// TODO Auto-generated method stub
		return adminDAO.inquireList();
	}

	@Override
	public void inquireinsert(AdminInquireBoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		adminDAO.inquireinsert(vo);
		
	}

	@Override
	public AdminInquireBoardVO inquireread(Integer seq) throws Exception {
		// TODO Auto-generated method stub
		return adminDAO.inquireread(seq);
	}

}
