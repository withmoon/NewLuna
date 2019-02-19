package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;

@Controller
public class UserKakaopayController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/kakaopay.udo", method=RequestMethod.POST)
	public ModelAndView kakaopayView(RoomInfoDTO roomin,MemberCommand memcom,RoomPaymentDTO roomPay,HttpSession session) {
		ModelAndView mav=new ModelAndView();
		
		memcom = (MemberCommand) session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		memcom=memser.getMyPageInfo(memcom);
		
		mav.addObject("roomInfo",roomin);
		mav.addObject("roomPay",roomPay);
		mav.addObject("member",memcom);
		return mav;
	}
}