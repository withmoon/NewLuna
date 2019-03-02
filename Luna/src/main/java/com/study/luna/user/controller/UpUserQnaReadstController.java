package com.study.luna.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.mg.service.MgService;
@Controller
public class UpUserQnaReadstController {
	@Autowired
	MgService mgser;
	
	@RequestMapping(value="/upUserQnaReadst.udo",method=RequestMethod.GET) 
	public @ResponseBody void upUserQnaReadst(@RequestParam("seq") int seq) {
		mgser.upUserQnaReadst(seq);
	}
			
}
