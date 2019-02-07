package com.study.luna.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.SHA256;

@Controller
public class UserMypageController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.GET)
	public ModelAndView mypageView(HttpSession session, MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		session.setAttribute("member", memcom);
		
		memcom=memser.getMyPageInfo(memcom);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;
	}
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.POST)
	public ModelAndView mainView(RedirectAttributes rdab,MemberCommand memcom,HttpSession session) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		MemberCommand memcomID=(MemberCommand)session.getAttribute("member");
		
		memcom.setId(memcomID.getId());
		
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		memser.upUserInfo(memcom);

		rdab.addFlashAttribute("id", memcom.getId());
		mav.setViewName("redirect:/mypage.udo");
		return mav;	
	}
}
