package com.study.luna.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class mgcalendarController {
	@RequestMapping(value="/refound.mdo", method=RequestMethod.GET)
	public String mgCalendarView() {
		return "refound";
	} 
}
