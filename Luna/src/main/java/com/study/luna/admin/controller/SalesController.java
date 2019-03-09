package com.study.luna.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.GetMemberPositionService;

@Controller
public class SalesController {
	
	@Autowired
	GetMemberPositionService getMemberPositionService;
	
	@RequestMapping(value = "/admin.ado", method = RequestMethod.GET)
	public String mainView( HttpServletRequest request, HttpSession session,
			HttpServletResponse response,MemberCommand memcom) throws IOException {


		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			String id=flashMap.get("id").toString();
			memcom.setId(id);
			String pos=getMemberPositionService.getMemberPosition(memcom.getId());
			memcom.setPosition(pos);
			if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
				session.setAttribute("member", memcom);
				return "admin";
			} else {
				return "cannotAccess";
			}
		} else if (session.getAttribute("member")!= null) {
			memcom = (MemberCommand) session.getAttribute("member");
			if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
				session.setAttribute("member", memcom);
				return "admin";
			} else {
				return "cannotAccess";
			}
		}
		return "cannotAccess";
	}

}