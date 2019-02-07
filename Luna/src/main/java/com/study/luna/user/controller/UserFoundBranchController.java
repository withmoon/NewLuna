package com.study.luna.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserFoundBranchController {
	
	@RequestMapping(value="/foundbranch.udo", method=RequestMethod.GET)
	public String foundBranchView() {
		return "foundbranch";
	}
}
