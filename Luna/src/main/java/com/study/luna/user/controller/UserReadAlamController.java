package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.alamandqa.service.AlamService;
import com.study.luna.user.dto.AlamDTO;

@Controller
public class UserReadAlamController {

	@Autowired
	AlamService alser;
	
	@RequestMapping("readalam.udo")
	public @ResponseBody void readalam(MemberCommand memcom,HttpSession session, AlamDTO ald,@RequestParam("seq")int seq) {
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		ald.setId(memcom.getId());
		ald.setSeq(seq);
		
		alser.readAlam(ald);
	}
}
