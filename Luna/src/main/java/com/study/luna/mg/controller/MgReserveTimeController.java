package com.study.luna.mg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.DAO.ReserveTimeDAO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.ReserveTimeVO;
import com.study.luna.mg.service.mgReserveTimeService;
import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.service.ReportService;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;

@Controller
public class MgReserveTimeController {
	//통계
	
	@Autowired
	mgReserveTimeService mgReserveTimeService; 
	@Autowired
	ReportService rpser;
	@Autowired
	PayAndReserveService prser;
	 
	@RequestMapping(value="/mgTime.mdo",method=RequestMethod.GET)
	public ModelAndView mgAgeView(ReserveTimeVO vo,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("카카오 로그인 실패");
			 mv.setViewName("/body/loginX");
	         return mv;
		}
		
		//리스트
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList();
		
		//통계계산
		mgReserveTimeService.mgsu(list,vo);
		
		
		
		mv.addObject("vo",vo);
		mv.setViewName("body/reserveTime/mgTime");

		return mv;
	}
	
	@RequestMapping(value="/mgchart.mdo",method=RequestMethod.POST)
	public  @ResponseBody List<ReserveTimeVO> getTermSales(@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end,ReserveTimeVO vo){
		
		/*List<RoomPaymentDTO> termSaleslist=prser.getTermSales(paid_at_start,paid_at_end);*/
		List<ReserveTimeVO> list = mgReserveTimeService.getreservcount();
		return list;
		
	}
	
	
	
	@RequestMapping(value="/mgSeason.mdo",method=RequestMethod.GET)
	public String mgSeasonView() {
		return "body/reserveTime/mgSeason";
	}
	
	@RequestMapping(value="/mgreport.mdo",method=RequestMethod.GET)
	public ModelAndView mgReportView() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("body/reserveTime/report");
		return mav;
	}
	
	
}
