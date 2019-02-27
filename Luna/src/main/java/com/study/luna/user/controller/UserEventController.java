package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;
import com.study.luna.mg.model.BoardPager;

@Controller
public class UserEventController {
	@Autowired
	AdminEventBoardService evntBoardService;
	
	//이벤트 목록
	//진행중인이벤트
	@RequestMapping(value="/event.udo", method=RequestMethod.GET)
	public ModelAndView eventView(@RequestParam(defaultValue="1") int curPage,
									ModelAndView mav, HttpSession session) {
		//페이징처리
		int count = evntBoardService.count(mav);
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<AdminEventBoardVO> eventList = evntBoardService.eventAll(start, end, session);
		
		mav.addObject("eventList", eventList);
		mav.addObject("boardPager", boardPager);
		
		return mav;
	}
	
	//종료이벤트
	@RequestMapping(value="/eventChange.udo", method=RequestMethod.GET)
	public @ResponseBody List<AdminEventBoardVO> eventEndView(@RequestParam(defaultValue="1") int curPage,
																@RequestParam(value="eEvnet", required=false,defaultValue="")String eEvent,
																ModelAndView mav, HttpSession session) {
		System.out.println("eEvent ==> "+eEvent);
		
		//페이징처리
		int count = evntBoardService.count(mav);
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<AdminEventBoardVO> eventList = new ArrayList<AdminEventBoardVO>();	
		if(eEvent.equals("endEv")) {
			eventList = evntBoardService.eventEndAll(start, end, session);
		}else {
			eventList = evntBoardService.eventAll(start, end, session);
		}

		mav.addObject("eventList", eventList);
		mav.addObject("boardPager", boardPager);
		
		return eventList;
	}
	
}
