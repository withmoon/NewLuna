package com.study.luna.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HowToUseController {

	@RequestMapping(value="/howtouse.ado")
	public String main() {
		
		return "howtouse";
	}
	
	
	@RequestMapping(value="/howtouseboard.ado")
	public String mains() {
		
		return "howtouseboard";
		
	}
	
	@RequestMapping(value="/howtouseview.ado")
	public String mainss() {
		
		return "howtouseview";
		
	}
}
