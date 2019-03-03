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
public class UserUpReviewContentController {
	@Autowired
	RoomReviewService rrser;
	
	@RequestMapping(value="/upReviewContent.udo",method = RequestMethod.GET)
	public @ResponseBody void upReviewContent(RoomReviewDTO rrd,HttpSession session,@RequestParam("reviewContent")String reviewContent,@RequestParam("roomnum")int roomnum){
		MemberCommand memcom=(MemberCommand)session.getAttribute("member");
		rrd.setId(memcom.getId());
		rrd.setReviewContent(reviewContent);
		rrd.setRoomNum(roomnum);
		rrser.upReviewContent(rrd);
	}
}
