package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class UserRoomDetailController {
	@RequestMapping(value = "/roomDetail.udo", method = RequestMethod.GET)
	public ModelAndView roomDetailView(MemberCommand memcom, HttpSession session)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		memcom = (MemberCommand) session.getAttribute("member");
		session.setAttribute("member", memcom);

		mav.addObject("member", session.getAttribute("member"));
		mav.setViewName("roomDetail");
		return mav;
	}
}
