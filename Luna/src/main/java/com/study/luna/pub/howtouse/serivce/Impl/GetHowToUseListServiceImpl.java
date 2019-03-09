package com.study.luna.pub.howtouse.serivce.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.dao.HowToUseDAO;
import com.study.luna.pub.howtouse.serivce.GetHowToUseListService;
@Service
public class GetHowToUseListServiceImpl implements GetHowToUseListService {
	
	@Autowired
	HowToUseDAO htuDAO;

	@Override
	public List<HowToUseDTO> getHowToUseList() {
		return htuDAO.getHowToUseList();
	}

}
