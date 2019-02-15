package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.service.RoomService;

@Controller
public class UserRoomDetailController {
	
	@Autowired
	RoomService romser;
	
	@RequestMapping(value = "/roomDetail.udo", method = RequestMethod.GET)
	public ModelAndView roomDetailView(RoomInfoDTO roomInfo,MemberCommand memcom, HttpSession session)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		memcom = (MemberCommand) session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		//roomInfo.setRoomNum(1);
		//roomInfo=romser.getRoomInfo(roomInfo);
		
		mav.addObject("roomInfo",roomInfo);
		mav.addObject("member", session.getAttribute("member"));
		mav.setViewName("roomDetail");
		return mav;
	}
}
