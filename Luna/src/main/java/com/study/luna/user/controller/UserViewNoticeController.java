package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminNoticeBoardService;

@Controller
public class UserViewNoticeController {
	@Autowired
	AdminNoticeBoardService noticeBoardService;
	
	//공지사항_질문사항 상세보기
	@RequestMapping(value="/viewNotice.udo", method=RequestMethod.GET)
	public ModelAndView viewNoticeView(int num, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewNotice");
		mav.addObject("nbv", noticeBoardService.read(num));
		return mav;
	}
}
