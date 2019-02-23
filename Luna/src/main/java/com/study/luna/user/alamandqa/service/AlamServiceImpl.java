package com.study.luna.user.alamandqa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.alamandqa.dao.Impl.GetAlamlistDAOImpl;
import com.study.luna.user.alamandqa.dao.Impl.ReadAlamDAOImpl;
import com.study.luna.user.dto.AlamDTO;
@Service
public class AlamServiceImpl implements AlamService {
	@Autowired
	GetAlamlistDAOImpl galDAOImpl;
	@Autowired
	ReadAlamDAOImpl raDAOImpl;
	
	@Override
	public List<AlamDTO> getAlamlist(MemberCommand memcom) {
		return galDAOImpl.getAlamlist(memcom);
	}

	@Override
	public void readAlam(AlamDTO ald) {
		raDAOImpl.readAlam(ald);
	}
	

}
