package com.study.luna.pub.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JoinController {
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String mainView() {
		return "join";
	}
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String kjoinView(HttpServletRequest request) {
		
		String kid=request.getParameter("kid");
		String nic=request.getParameter("knic");
		
		System.out.println(kid +" 안나오냐 "+nic);
		
		return "join";
	}
}