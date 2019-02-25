package com.study.luna.pub.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class MainViewController {
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public ModelAndView mainView(HttpSession session,MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
				
		session.setAttribute("member", memcom);
		//여까지 고침
		mav.setViewName("mainpage");
		return mav;
	}
}
