package com.study.luna.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserKakaopayController {
	@RequestMapping(value="/kakaopay.udo", method=RequestMethod.GET)
	public String kakaopayView() {
		return "kakaopay";
	}
}