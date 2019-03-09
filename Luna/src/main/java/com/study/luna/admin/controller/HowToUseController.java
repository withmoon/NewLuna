package com.study.luna.admin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.luna.pub.command.MemberCommand;

@Controller
public class HowToUseController {

	@RequestMapping(value="/howtouse.ado")
	public String main(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			return "howtouse";
		}
		return "cannotAccess";

	}
	
	
	@RequestMapping(value="/howtouseboard.ado")
	public String mains(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			return "howtouseboard";
		}
		return "cannotAccess";

		
	}
	
	@RequestMapping(value="/howtouseview.ado")
	public String mainss(HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			return "howtouseview";
		}
		return "cannotAccess";
	}
}
