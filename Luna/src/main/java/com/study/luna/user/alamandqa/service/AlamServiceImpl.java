package com.study.luna.user.alamandqa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.alamandqa.dao.Impl.GetAlamCountDAOImpl;
import com.study.luna.user.alamandqa.dao.Impl.GetAlamlistDAOImpl;
import com.study.luna.user.alamandqa.dao.Impl.ReadAlamDAOImpl;
import com.study.luna.user.dto.AlamDTO;
@Service
public class AlamServiceImpl implements AlamService {
	@Autowired
	GetAlamlistDAOImpl galDAOImpl;
	@Autowired
	ReadAlamDAOImpl raDAOImpl;
	@Autowired
	GetAlamCountDAOImpl gacDAOImpl;
	@Override
	public List<AlamDTO> getAlamlist(int start, int end,String id) {
		return galDAOImpl.getAlamlist(start,end,id);
	}

	@Override
	public void readAlam(AlamDTO ald) {
		raDAOImpl.readAlam(ald);
	}

	@Override
	public Integer getAlamCount(String id) {
		return gacDAOImpl.getAlamCount(id);
	}
}
