package com.study.luna.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MgReserveTimeController {

	
	@RequestMapping(value="/MgAge.mdo",method=RequestMethod.GET)
	public String mgAgeView() {
		return "body/reserveTime/age";
	}
	
	@RequestMapping(value="/MgSeason.mdo",method=RequestMethod.GET)
	public String mgSeasonView() {
		return "body/reserveTime/season";
	}
	
	
}
