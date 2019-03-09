package com.study.luna.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class ReportController {

	@RequestMapping(value="/reportboard.ado")
	public String report(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			return "reportboard";
		}
		return "cannotAccess";
		

	}
	
	@RequestMapping(value="/reportwrite.ado")
	public String write(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
						
			return "reportwrite";
		}
		return "cannotAccess";

	}
}