package com.study.luna.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;

@Controller
public class UserEventController {
	@Autowired
	AdminEventBoardService evntBoardService;
	
	//이벤트 목록
	//진행중
	@RequestMapping(value="/event.udo", method=RequestMethod.GET)
	public ModelAndView eventView(AdminEventBoardVO ebVO) {
		List<AdminEventBoardVO> eventList = evntBoardService.eventList(ebVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventList", eventList);

		return mav;
	}
	
	//마감
	@RequestMapping(value="/event.udo")
	public ModelAndView eventEndView(AdminEventBoardVO ebVO) {
		List<AdminEventBoardVO> eventEndList = evntBoardService.eventEndList(ebVO);
		ModelAndView mav = new ModelAndView();
		mav.addObject("eventEndList", eventEndList);

		return mav;
	}
}
