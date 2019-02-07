package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class Mypage {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.GET)
	public ModelAndView mypageView(HttpSession session, MemberCommand memcom) {
		ModelAndView mav=new ModelAndView();
		
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		System.out.println("마이페이지 아이디=="+memcom.getId());
		
		memcom=memser.getMyPageInfo(memcom);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;
	}
}
