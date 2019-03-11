package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.UpdateHowToUseContentService;
@Service
public class UpdateHowToUseContentServiceImpl implements UpdateHowToUseContentService {
	
	@Autowired
	HowToUseDAO howToUseDAO;

	@Override
	public void updateHowToUseContent(HowToUseDTO htu) {
		howToUseDAO.updateHowToUseContent(htu);
	}

}
