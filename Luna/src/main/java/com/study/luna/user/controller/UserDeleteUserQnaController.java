package com.study.luna.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.mg.service.MgService;

@Controller
public class UserDeleteUserQnaController {
	@Autowired
	MgService mgser;
	
	@RequestMapping(value="/deleteUserQna.udo",method=RequestMethod.GET) 
	public @ResponseBody void deleteUserQna(@RequestParam("seq") int seq) {
		mgser.deleteUserQna(seq);
	}
			
}
