package com.study.luna.pub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String mainView(HttpSession session,HttpServletRequest req){
		String url=req.getHeader("REFERER");
		String redirectUrl=url.substring(26);
		session.setAttribute("rdUrl", redirectUrl);
		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String mainViews(HttpSession session,HttpServletRequest req){
		String url=req.getHeader("REFERER");
		String redirectUrl=url.substring(26);
		session.setAttribute("rdUrl", redirectUrl);
		return "login";
	}
}