package com.study.luna.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MgReserveTimeController {
	//���ȭ��
	
	@RequestMapping(value="/mgAge.mdo",method=RequestMethod.GET)
	public String mgAgeView() {
		return "body/reserveTime/mgAge";
	}
	
	@RequestMapping(value="/mgSeason.mdo",method=RequestMethod.GET)
	public String mgSeasonView() {
		return "body/reserveTime/mgSeason";
	}
	
	
}
