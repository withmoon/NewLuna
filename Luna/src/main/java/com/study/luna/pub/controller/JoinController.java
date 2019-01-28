package com.study.luna.pub.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {
	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public ModelAndView mainView(@RequestParam("br") String br){
		ModelAndView mav=new ModelAndView();
		mav.addObject("br",br);
		mav.setViewName("join");
		return mav;
	}
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public ModelAndView kjoinView(@RequestParam("kid") String kid, @RequestParam("knic") String knic){
		System.out.println(kid +" 안나오냐 "+knic);
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("kid", "k#"+kid);
		mav.addObject("knic",knic);
		mav.addObject("br","off");
		mav.setViewName("join");
		return mav;
	}
}