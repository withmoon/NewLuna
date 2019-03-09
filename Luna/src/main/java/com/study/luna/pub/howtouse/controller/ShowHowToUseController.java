package com.study.luna.pub.howtouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.serivce.GetHowToUseContentService;

@Controller
public class ShowHowToUseController {
	
	@Autowired
	GetHowToUseContentService getHowToUseContentService;
	
	@RequestMapping("showHowToUse.ado")
	public ModelAndView showHowToUse(@RequestParam int num) {
		ModelAndView mav=new ModelAndView();
		
		HowToUseDTO htu=getHowToUseContentService.getHowToUseContent(num);
		
		mav.addObject("htu",htu);
		return mav;
	}

}
