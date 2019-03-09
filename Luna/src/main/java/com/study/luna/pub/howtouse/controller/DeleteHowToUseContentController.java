package com.study.luna.pub.howtouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.howtouse.serivce.DeleteHowToUseContentService;

@Controller
public class DeleteHowToUseContentController {
	
	@Autowired
	DeleteHowToUseContentService deleteHowToUseContentService;
	
	@RequestMapping(value="deleteHowToUseContent.do",method=RequestMethod.POST)
	public @ResponseBody void deleteHowToUseContent(HowToUseDTO htu){
		deleteHowToUseContentService.deleteHowToUseContent(htu);
	}
}
