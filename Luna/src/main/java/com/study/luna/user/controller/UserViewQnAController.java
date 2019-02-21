package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminQnABoardService;

@Controller
public class UserViewQnAController {
	@Autowired
	AdminQnABoardService qnaBoardService;
	
	//공지사항_질문사항 상세보기
	@RequestMapping(value="/viewQnA.udo", method=RequestMethod.GET)
	public ModelAndView viewQnAView(int num, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewQnA");
		mav.addObject("qbv", qnaBoardService.qnaRead(num));
		return mav;
	}
}
