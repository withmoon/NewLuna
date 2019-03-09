package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.GetHowToUseContentService;
@Service
public class GetHowToUseContentServiceImpl implements GetHowToUseContentService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public HowToUseDTO getHowToUseContent(int num) {
		return htuDAO.getHowToUseContent(num);
	}

}
