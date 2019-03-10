package com.study.luna.pub.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.pub.member.service.RefundofexpulService;

@Controller
public class DeactivateMemberController {
	
	@Autowired
	MemberService memser;
	@Autowired
	RefundofexpulService refundofexpulService;
	
	@RequestMapping(value = "deactivatemember.do" ,method=RequestMethod.POST)
	public @ResponseBody void deactivatemember(HttpSession session,MemberCommand memcom){
			memcom=(MemberCommand)session.getAttribute("member");
			memser.expulmember(memcom.getId());
			refundofexpulService.refundofexpul(memcom.getId());
	}
}
