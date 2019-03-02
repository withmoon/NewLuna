package com.study.luna.mg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.ReserveTimeVO;
import com.study.luna.mg.service.mgReserveTimeService;

@Controller
public class MgReserveTimeController {
	//통계
	
	@Autowired
	mgReserveTimeService mgReserveTimeService;
	
	@RequestMapping(value="/mgTime.mdo",method=RequestMethod.GET)
	public ModelAndView mgAgeView(ReserveTimeVO vo) {
		
		//리스트
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList();
		
		//통계계산
		mgReserveTimeService.mgsu(list,vo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo",vo);
		mv.setViewName("body/reserveTime/mgTime");

		return mv;
		
		
		
		
	}
	
	@RequestMapping(value="/mgSeason.mdo",method=RequestMethod.GET)
	public String mgSeasonView() {
		return "body/reserveTime/mgSeason";
	}
	
	
}
