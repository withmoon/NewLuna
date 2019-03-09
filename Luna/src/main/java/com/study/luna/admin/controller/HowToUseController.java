package com.study.luna.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.howtouse.serivce.GetHowToUseListService;

@Controller
public class HowToUseController {
	@Autowired
	GetHowToUseListService getHowToUseListService;
	
	@RequestMapping(value="/howtouseboard.ado")
	public ModelAndView mains(HttpSession session, MemberCommand memcom) {
		ModelAndView mav=new ModelAndView();
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			List<HowToUseDTO> htulist=getHowToUseListService.getHowToUseList();
			mav.addObject("htulist",htulist);
			mav.setViewName("howtouseboard");
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;
	}
	
	
}
