package com.study.luna.pub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class LogOutController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(MemberCommand memcom,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		session.invalidate();
		mav.setViewName("redirect:/main.do");
		return mav;
	}
}
