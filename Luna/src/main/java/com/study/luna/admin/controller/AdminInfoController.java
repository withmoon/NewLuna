package com.study.luna.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class AdminInfoController {

	@RequestMapping(value = "/admininfo.ado", method = RequestMethod.GET)
	public String view(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			return "admininfo";
		}
		return "cannotAccess";
	}
}
