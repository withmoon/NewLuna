package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class UserEventController {
	@RequestMapping(value="/event.udo", method=RequestMethod.GET)
	public String eventView(MemberCommand memcom, HttpSession session) {
		/*
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		*/
		return "event";
	}
}
