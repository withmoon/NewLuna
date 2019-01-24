package com.study.luna.pub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainViewController {
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String mainView() {
		System.out.println("여기 왔다감");
		return "mainpage";
	}
}
