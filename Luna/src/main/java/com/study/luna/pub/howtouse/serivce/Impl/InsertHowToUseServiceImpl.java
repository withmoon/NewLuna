package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.InsertHowToUseService;
@Service
public class InsertHowToUseServiceImpl implements InsertHowToUseService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void insertHowToUse(HowToUseDTO htu) {
		htuDAO.insertHowToUse(htu);
	}

}
