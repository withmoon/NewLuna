package com.study.luna.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
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
	public ModelAndView homeloginView(RedirectAttributes rdab,MemberCommand memcom,@RequestParam("kid") String kid, @RequestParam("knic") String knic) throws Exception {
		ModelAndView mav=new ModelAndView();
		
		if(!kid.equals("")) { //일반 또는 지점장 회원시
			memcom.setKid(kid);
			memcom.setPw(knic);
		}
		memcom.setBranchAddr2(memcom.getBranchAddr2()+"#"+memcom.getBranchAddr3());
		//비번 암호화
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		memser.insertMember(memcom);
		
		String branchName=memcom.getBranchName();
		rdab.addFlashAttribute("id", memcom.getId());
		if(branchName==null) {
			mav.setViewName("redirect:/log/home.udo");
			return mav;
		}else{
			mav.setViewName("redirect:/manager.mdo");
			return mav;
		}
	}
	
	//일반 로그인
	@RequestMapping(value="/log/home.udo", method=RequestMethod.GET)
	public ModelAndView homeView(MemberCommand memcom,HttpServletRequest request) throws Exception {
		ModelAndView mav=new ModelAndView();
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		System.out.println("회원 로그인 ==>"+flashMap.get("id"));
		mav.setViewName("home");
		
		return mav;
	}

}