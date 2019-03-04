package com.study.luna.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;

@Controller
public class UserEventController {
	@Autowired
	AdminEventBoardService evntBoardService;
	
	//이벤트 목록
	//진행중인이벤트
	@RequestMapping(value="/event.udo", method=RequestMethod.GET)
	public String eventView(MemberCommand memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		
		return "event";
	}
	
	//이벤트 목록
	//진행중인이벤트
	@RequestMapping(value="/eventOK.udo", method=RequestMethod.GET)
	public @ResponseBody JSONObject eventOKView(@RequestParam(defaultValue="1") int curPage,
												AdminEventBoardVO eventboardVO, HttpSession session) {
		//페이징처리
		int count = evntBoardService.countEvent(eventboardVO.getTitle());
			
		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
			
		List<AdminEventBoardVO> eventList = evntBoardService.eventAll(start, end, session);
			
		JSONObject obj = new JSONObject();

		obj.put("eventList", eventList);
		obj.put("eNowPage", boardPager);
		return obj;
	}
	
	//종료이벤트
	@RequestMapping(value="/eventChange.udo", method=RequestMethod.GET)
	public @ResponseBody JSONObject eventEndView(@RequestParam(defaultValue="1") int curPage,
												AdminEventBoardVO eventboardVO, HttpSession session) {
		//페이징처리
		int count = evntBoardService.countEventEnd(eventboardVO.getTitle());
		
		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<AdminEventBoardVO> eventEndList = evntBoardService.eventEndAll(start, end, session);

		JSONObject obj = new JSONObject();
		
		obj.put("eventEndList", eventEndList);
		obj.put("eFinshPage", boardPager);
		return obj;
	}
	
}
