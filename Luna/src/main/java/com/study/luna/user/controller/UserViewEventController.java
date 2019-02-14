package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;

@Controller
public class UserViewEventController {
	@Autowired
	AdminEventBoardService evntBoardService;
	
	//이벤트 상세보기
	@RequestMapping(value="/viewEvent.udo", method=RequestMethod.GET)
	public ModelAndView viewEventView(@RequestParam int seq, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewEvent");
		mav.addObject("ebv", evntBoardService.read(seq));
		return mav;
	}
}