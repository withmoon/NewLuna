package com.study.luna.pub.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class GetAdminListController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="getAdminList.do", method=RequestMethod.POST)
	public @ResponseBody List<MemberCommand> getAdminList (){
		List<MemberCommand> list=memser.getAdminList();
		return list;
	}
}
