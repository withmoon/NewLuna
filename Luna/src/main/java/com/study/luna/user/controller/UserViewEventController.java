package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.user.comment.service.EventReplyService;
import com.study.luna.user.comment.vo.EventReplyVO;

@Controller
public class UserViewEventController {
	@Autowired
	AdminEventBoardService eventBoardService;
	@Autowired
	EventReplyService eventReplyService;
	
	//이벤트 상세보기
	@RequestMapping(value="/viewEvent.udo", method=RequestMethod.GET)
	public ModelAndView viewEventView( int seq, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewEvent");
		mav.addObject("ebv", eventBoardService.read(seq));
		return mav;
	}
	
	//이벤트 댓글 입력
	@RequestMapping(value="/eReplyInsert.udo", method=RequestMethod.GET)
	public void eReplyInsert(@ModelAttribute EventReplyVO eReplyVO, 
							@RequestParam(value="eReplyI", required=false,defaultValue="")String eReplyI,
							HttpSession session) {
		
		if(eReplyI.equals("eReI")) {
			eventReplyService.create(eReplyVO);
		}
		String id = (String) session.getAttribute("id");
		eReplyVO.setReplyer(id);
	}
	
	//이벤트 댓글 목록
	@RequestMapping(value="/eReplyList.udo", method=RequestMethod.GET)
	public ModelAndView eReplyView(@RequestParam(defaultValue="1") int seq,
								@RequestParam(value="eReplyL", required=false,defaultValue="")String eReplyL,
								ModelAndView mav) {
		List<EventReplyVO> eReplyList = new ArrayList<EventReplyVO>();
		
		if(eReplyL.equals("eReL")) {
			eReplyList = eventReplyService.eReplyList(seq);
		}
		
		mav.addObject("eReplyList", eReplyList);
		
		return mav;
	}
}