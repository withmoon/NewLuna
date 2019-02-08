package com.study.luna.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.room.service.RoomServiceImpl;

@Controller
public class UserGetBranchSidoguController {
	
	@Autowired
	RoomServiceImpl roomser;

	@RequestMapping(value="/getSidoGugun.udo")
	public @ResponseBody List<String> getSidoGugung(@RequestParam("undefined")String sido){
		System.out.println("현재 지역 ===>"+sido);
		
		List<String> list=roomser.getGugun(sido);
		
		return list;
	}
}
