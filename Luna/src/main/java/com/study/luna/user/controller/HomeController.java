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
		System.out.println(memcom.getName());
		System.out.println("카카오로그인===>"+kid);
		System.out.println("카카오로그인===>"+knic);
		
		if(kid.equals("")) {
			//pw 암호화 후 주입
			System.out.println("여기가 회원 또는 지점장 로긘");
			
			System.out.println(memcom.getPhone());
			
			//memser.insertMember(memcom);
		}else{
			memcom.setKid(kid);
			memcom.setName(knic);
			
			//kic 암호화 후 pw 주입
			System.out.println("카카오 로그인");
			memser.insertMember(memcom);
		}
		
		return "home";
	}
}
