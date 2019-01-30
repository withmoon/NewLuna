package com.study.luna.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class HomeController {
	@RequestMapping(value="/home.udo", method=RequestMethod.GET)
	public String homeView() {
		return "home";
	}
	@RequestMapping(value="/home.udo", method=RequestMethod.POST)
	public String homeloginView(MemberCommand memcom,@RequestParam("kid") String kid, @RequestParam("knic") String knic) {
		System.out.println(memcom.getName());
		System.out.println("카카오로그인===>"+memcom.getKid());
		System.out.println("카카오로그인===>"+memcom.getKnic());
		
		return "home";
	}
}
