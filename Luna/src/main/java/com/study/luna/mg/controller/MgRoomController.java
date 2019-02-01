package com.study.luna.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.luna.mg.service.MgService;

@Controller
public class MgRoomController {

	@Autowired
	public MgService mgService;
	
	@RequestMapping(value="/MgRoom.mdo",method=RequestMethod.GET)
	public String  mgRoomList() {
		return "body/room/MgRoom";
	}
}
