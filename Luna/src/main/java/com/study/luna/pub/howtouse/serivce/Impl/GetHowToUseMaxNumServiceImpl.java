package com.study.luna.pub.howtouse.serivce.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.GetHowToUseMaxNumService;

@Service
public class GetHowToUseMaxNumServiceImpl implements GetHowToUseMaxNumService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public Integer getHowToUseMaxNum() {
		return htuDAO.getHowToUseMaxNum();
	}

}
