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
public class UserMypageController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.GET)
	public ModelAndView mypageView(HttpSession session, MemberCommand memcom) {
		ModelAndView mav=new ModelAndView();
		
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		memcom=memser.getMyPageInfo(memcom);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;
	}
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.POST)
	public ModelAndView mainView(MemberCommand memcom,HttpSession session){
		ModelAndView mav=new ModelAndView();
		
		MemberCommand memcomID=(MemberCommand)session.getAttribute("member");
		
		System.out.println("<=====여기부터 마이페이지 정보수정=====>");
		System.out.println("이름==>"+memcom.getName());
		System.out.println("이메일==>"+memcom.getEmail());
		System.out.println("번호==>"+memcom.getPhone());
		System.out.println("비번==>"+memcom.getPw());
		
		memcom.setId(memcomID.getId());
		
		memser.upUserInfo(memcom);
		
		session.setAttribute("member", memcomID);
		
		memcom=memser.getMyPageInfo(memcom);
		
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;	
	}
}
