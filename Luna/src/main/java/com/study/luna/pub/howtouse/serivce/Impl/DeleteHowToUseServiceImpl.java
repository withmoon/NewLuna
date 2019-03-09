package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.DeleteHowToUseService;
@Service
public class DeleteHowToUseServiceImpl implements DeleteHowToUseService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void deleteHowToUse(int num) {
		htuDAO.deleteHowToUse(num);
	}

}
