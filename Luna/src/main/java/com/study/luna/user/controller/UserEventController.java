package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/eventChange.udo", method=RequestMethod.GET)
	public @ResponseBody List<AdminEventBoardVO> eventEndView(AdminEventBoardVO adebv,@RequestParam(value="eEvnet", required=false,defaultValue="")String eEvent) {

		List<AdminEventBoardVO> eventList = new ArrayList<AdminEventBoardVO>();	
		if(eEvent=="end") {
			adebv.setSeq(4);
			adebv.setTitle("종료된 이벤트");
			adebv.setWriter("종료됐지롱");
			adebv.setStartdate(new Date());
			adebv.setEnddate(new Date());
			eventList.add(adebv);
		}else {
			eventList = evntBoardService.eventList(adebv);
		}
		return eventList;
	}
	
}
