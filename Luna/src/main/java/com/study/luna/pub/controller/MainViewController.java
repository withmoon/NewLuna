package com.study.luna.pub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class MainViewController {
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public ModelAndView mainView(HttpSession session,MemberCommand memcom) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("member",session.getAttribute("member"));
		mav.setViewName("mainpage");
		return mav;
	}
}
