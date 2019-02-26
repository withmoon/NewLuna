package com.study.luna.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.service.RoomReviewServiceImpl;

@Controller
public class UserGetRoomAllReviewController {
	@Autowired
	RoomReviewServiceImpl rrser;

	@RequestMapping(value="/getRoomAllReview.udo",method = RequestMethod.GET)
	public @ResponseBody List<RoomReviewDTO> getSidoGugung(@RequestParam("roomnum")int roomnum){
		List<RoomReviewDTO> list=rrser.getRoomAllReview(roomnum);
		return list;
	}
}
