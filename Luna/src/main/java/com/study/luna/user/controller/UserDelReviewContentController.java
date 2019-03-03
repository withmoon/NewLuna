package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.service.RoomReviewService;

@Controller
public class UserDelReviewContentController {
	@Autowired
	RoomReviewService rrser;
	
	@RequestMapping(value="/delReviewContent.udo",method = RequestMethod.GET)
	public @ResponseBody void delReviewContent(RoomReviewDTO rrd,HttpSession session,@RequestParam("roomnum")int roomnum){
		MemberCommand memcom=(MemberCommand)session.getAttribute("member");
		rrd.setId(memcom.getId());
		rrd.setRoomNum(roomnum);
		rrser.delReviewContent(rrd);
	}
}
