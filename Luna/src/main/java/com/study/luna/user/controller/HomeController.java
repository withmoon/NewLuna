package com.study.luna.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.BCrypt;
import com.study.luna.util.SHA256;

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
		
		SHA256 sha=SHA256.getInsatnce();
		String shaPass="";
		String bcPass="";
		try {
			shaPass = sha.getSha256(memcom.getPw().getBytes());
			bcPass=BCrypt.hashpw(shaPass, BCrypt.gensalt());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memcom.setPw(bcPass);
		
		memser.insertMember(memcom);
		
		return "home";
	}
}
/*
//값 넘김 테스트 js 확인용
System.out.println(memcom.getZipcode());
System.out.println(memcom.getBranchAddr1());
System.out.println(memcom.getBranchAddr2());
System.out.println(memcom.getBranchName());
*/