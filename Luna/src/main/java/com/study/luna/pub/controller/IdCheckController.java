package com.study.luna.pub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IdCheckController {
	@RequestMapping(value="idCheck.do",method=RequestMethod.POST)
	public ModelAndView idCehck(@RequestParam("id") String id){
		ModelAndView mav=new ModelAndView();
				
		mav.addObject("id",id);
		mav.addObject("message","사용가능한 아이디입니다."); //존재하는 아이디 입니다.
		mav.addObject("btnMessage","사용하기"); //닫기
		mav.setViewName("idCheck");
		
		return mav;
	}
}
