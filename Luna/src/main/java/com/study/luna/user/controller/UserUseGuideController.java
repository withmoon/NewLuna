package com.study.luna.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.howtouse.serivce.GetHowToUseListService;

@Controller
public class UserUseGuideController {
	@Autowired
	GetHowToUseListService getHowToUseListService;
	
	@RequestMapping(value="/useGuide.udo",method=RequestMethod.GET)
	public ModelAndView useGuide(MemberCommand memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);
		
		ModelAndView mav=new ModelAndView();
		
		List<HowToUseDTO> htulist=getHowToUseListService.getHowToUseList();
		mav.setViewName("useGuide");
		mav.addObject("htulist",htulist);
		return mav;
	}
}
