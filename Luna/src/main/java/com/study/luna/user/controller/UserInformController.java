package com.study.luna.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserInformController {
	@RequestMapping(value="/inform.udo", method=RequestMethod.GET)
	public ModelAndView informView(@RequestParam(value="cmd",required=false,defaultValue="") String cmd) {
		ModelAndView mav=new ModelAndView();
		if(cmd.equals("quest")) {
			
		}
		mav.addObject("cmd",cmd);
		mav.setViewName("inform");
		return mav;
	}
}
