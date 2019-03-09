package com.study.luna.pub.howtouse.controller;

import java.util.List;

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
	
	@RequestMapping("showHowToUse.do")
	public ModelAndView showHowToUse(@RequestParam("num") int num) {
		ModelAndView mav=new ModelAndView();
		
		List<HowToUseDTO> htuctlist=getHowToUseContentService.getHowToUseContent(num);
		
		int size = htuctlist.size();
		
		for(HowToUseDTO htulists:htuctlist) {
			htulists.setContent(htulists.getContent().replace("<br>","\r\n"));
		}
		
		mav.setViewName("../admin/showHowToUse");
		mav.addObject("htuctlist",htuctlist);
		mav.addObject("size",size);
		return mav;
	}

}
