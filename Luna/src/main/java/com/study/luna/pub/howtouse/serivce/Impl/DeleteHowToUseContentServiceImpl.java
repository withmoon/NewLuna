package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.DeleteHowToUseContentService;

@Service
public class DeleteHowToUseContentServiceImpl implements DeleteHowToUseContentService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public void deleteHowToUseContent(HowToUseDTO htu) {
		htuDAO.deleteHowToUseContent(htu);
	}

}
