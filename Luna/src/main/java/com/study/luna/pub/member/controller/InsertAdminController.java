package com.study.luna.pub.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.util.SHA256;

@Controller
public class InsertAdminController {
	@Autowired
	MemberService memser;
	
	@RequestMapping(value="insertAdmin.do", method=RequestMethod.POST)
	public @ResponseBody void insertAdmin (MemberCommand memcom) throws Exception{
		System.out.println("idididid=============>"+memcom.getId()+"=========================>"+memcom.getPw()+"==================>"+memcom.getPhone()+"=============================>"+memcom.getName()+"=================================>"+memcom.getEmail());
		
		//비번 암호화
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		memser.insertAdmin(memcom);
	}
}
