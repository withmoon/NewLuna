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
		
		memcom.setBranchAddr2(memcom.getBranchAddr2()+"#"+memcom.getBranchAddr3());
		
		//값 넘김 테스트 js 확인용
		System.out.println(memcom.getZipcode());
		System.out.println(memcom.getBranchAddr1());
		System.out.println(memcom.getBranchAddr2());
		System.out.println(memcom.getBranchName());
		
		memser.insertMember(memcom);
		
		return "home";
	}
}
