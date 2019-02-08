package com.study.luna.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.user.board.service.EventBoardService;
import com.study.luna.user.board.vo.EventBoardVO;

@Controller
public class UserEventController {
	@Autowired
	EventBoardService evntBoardService;
	
	//게시판 목록
	@RequestMapping(value="/event.udo", method=RequestMethod.GET)
	public ModelAndView eventView(EventBoardVO ebVO) {
		List<EventBoardVO> eventList = evntBoardService.eventList(ebVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventList", eventList);

		return mav;
	}
}
