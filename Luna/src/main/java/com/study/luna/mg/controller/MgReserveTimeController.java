package com.study.luna.mg.controller;

import java.util.List;import org.apache.ibatis.annotations.One;
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
	
	@RequestMapping(value="/mgAge.mdo",method=RequestMethod.GET)
	public ModelAndView mgAgeView(ReserveTimeVO vo) {
		
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList();
		
		mgReserveTimeService.mgsu(list);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/reserveTime/mgAge");

		return mv;
		
		
		
		
	}
	
	@RequestMapping(value="/mgSeason.mdo",method=RequestMethod.GET)
	public String mgSeasonView() {
		return "body/reserveTime/mgSeason";
	}
	
	
}
