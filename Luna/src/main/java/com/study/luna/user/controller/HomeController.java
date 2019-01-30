package com.study.luna.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/home.udo", method=RequestMethod.GET)
	public String homeView() {
		return "home";
	}
	@RequestMapping(value="/home.udo", method=RequestMethod.POST)
	public String homeloginView(MemberCommand memcom,@RequestParam("kid") String kid, @RequestParam("knic") String knic) {
		
		if(!kid.equals("")) { //일반 또는 지점장 회원시
			memcom.setKid(kid);
			memcom.setPw(knic);
		}
		
		memser.insertMember(memcom);
		
		return "home";
	}
}
