package com.study.luna.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.HowToUseDTO;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.howtouse.serivce.GetHowToUseContentService;

@Controller
public class UserViewUseGuideController {
	@Autowired
	GetHowToUseContentService getHowToUseContentService;
	
	@RequestMapping("viewUseGuide.udo")
	public ModelAndView viewUserGuide(@RequestParam("num") int num, MemberCommand memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);
		
		ModelAndView mav=new ModelAndView();
		
		List<HowToUseDTO> htuctlist=getHowToUseContentService.getHowToUseContent(num);
		
		int size = htuctlist.size();
		
		for(HowToUseDTO htulists:htuctlist) {
			htulists.setContent(htulists.getContent().replace("<br>","\r\n"));
		}
		
		mav.setViewName("viewUseGuide");
		mav.addObject("htuctlist",htuctlist);
		mav.addObject("size",size);
		return mav;
	}
}
