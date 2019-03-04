package com.study.luna.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;
import com.study.luna.mg.model.BoardPager;


@Controller
public class AdminEventController {
	@Autowired
	AdminEventBoardService evntBoardService;
    
    @RequestMapping(value="/event.ado", method=RequestMethod.GET)
    public String mainView() {
    	return "event";
    }
    
    //이벤트목록
    //진행중인이벤트
    @RequestMapping(value="/eventNow.ado", method=RequestMethod.GET)
    public @ResponseBody JSONObject eventNow(@RequestParam(defaultValue="1") int curPage,
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
  	@RequestMapping(value="/eventEnd.ado", method=RequestMethod.GET)
  	public @ResponseBody JSONObject eventEnd(@RequestParam(defaultValue="1") int curPage,
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
 