package com.study.luna.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.BCrypt;
import com.study.luna.util.SHA256;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memser;
	//로그인 없이 들어옴
	@RequestMapping(value="/nolog/home.udo", method=RequestMethod.GET)
	public String nologViewhome() {
		return"home";
	}
	
	//카카오로그인
	@RequestMapping(value="/home.udo", method=RequestMethod.GET)
	public String homeViewtget(HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		System.out.println("카카오 로그인==>"+flashMap.get("id"));
		return "home";
	}
	
	//회원가입 로그인
	@RequestMapping(value="/join/home.udo", method=RequestMethod.POST)
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
	
	//일반 로그인
	@RequestMapping(value="home.udo", method=RequestMethod.POST)
	public ModelAndView homeView(MemberCommand memcom) {
		ModelAndView mav=new ModelAndView();
		
		if(memcom.getBranchName()==null) {
			System.out.println("회원 로그인 ==>"+memcom.getId());
			mav.setViewName("home");
		}else {
			System.out.println("매니저 로그인==>"+memcom.getId());
			mav.setViewName("redirect:/manager.mdo");
		}
		return mav;
	}

}
/*
//값 넘김 테스트 js 확인용
System.out.println(memcom.getZipcode());
System.out.println(memcom.getBranchAddr1());
System.out.println(memcom.getBranchAddr2());
System.out.println(memcom.getBranchName());
*/