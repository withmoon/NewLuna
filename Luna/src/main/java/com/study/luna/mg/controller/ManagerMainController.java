package com.study.luna.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManagerMainController {

	@RequestMapping(value="/manager.mdo", method=RequestMethod.GET)
	public String mainView() {
		return "manager";
	} 
}
