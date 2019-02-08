package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserGetBranchSidoguController {

	@RequestMapping(value="/getSidoGugun.udo")
	public @ResponseBody List<String> getSidoGugung(@RequestParam("undefined")String sido){
		System.out.println("현재 지역 ===>"+sido);
		
		List<String> list=new ArrayList<String>();
		list.add("강남구");
		list.add("강서구");
		list.add("강북구");
		list.add("강동구");
		return list;
	}
}
