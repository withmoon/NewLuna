package com.study.luna.mg.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	//�넻怨�
	
	@Autowired
	mgReserveTimeService mgReserveTimeService; 
	@Autowired
	ReportService rpser;
	@Autowired
	PayAndReserveService prser;
	 
	@RequestMapping(value="/mgTime.mdo")
	public ModelAndView mgAgeView(ReserveTimeVO vo,@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end,HttpSession session){
	
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			 mv.setViewName("/body/loginX");
	         return mv;
		}
		if(paid_at_start==null || paid_at_start.equals("") ) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if(paid_at_end==null || paid_at_end.equals("") ) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		
		//由ъ뒪�듃
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList(paid_at_start,paid_at_end);
		
		//�넻怨꾧퀎�궛
		mgReserveTimeService.mgsu(list,vo);
		
	
		
		mv.addObject("vo",vo);
		mv.setViewName("body/reserveTime/mgTime");

		return mv;
	}
	
	@RequestMapping(value="/mgTime2.mdo")
	@ResponseBody 
	public ReserveTimeVO mgAgeView2(ReserveTimeVO vo,@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end,@RequestParam Map<String, Object> paramMap){
	
		if(paid_at_start==null || paid_at_start.equals("") ) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if(paid_at_end==null || paid_at_end.equals("") ) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		
		//由ъ뒪�듃
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList(paid_at_start,paid_at_end);
		
		//�넻怨꾧퀎�궛
		mgReserveTimeService.mgsu(list,vo);
		return vo;
 
	}
	
	
	@RequestMapping(value="/mgchart.mdo",method=RequestMethod.POST)
	public  @ResponseBody List<ReserveTimeVO> getTermSales(@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end,ReserveTimeVO vo,HttpSession session){
		
		if(paid_at_start==null || paid_at_start.equals("") ) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if(paid_at_end==null || paid_at_end.equals("") ) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		
		//李⑦듃 �뜲�씠�꽣
		String branchName = (String) session.getAttribute("branchName");
		/*List<RoomPaymentDTO> termSaleslist=prser.getTermSales(paid_at_start,paid_at_end);*/
		List<ReserveTimeVO> list = mgReserveTimeService.getreservcount(paid_at_start,paid_at_end,branchName);
		return list;
		
	}
	@RequestMapping(value="/mgchart2.mdo",method=RequestMethod.POST)
	public  @ResponseBody List<ReserveTimeVO> getTermSales2(@RequestParam(value="paid_at_start",defaultValue = "19/02/15") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "19/03/11") String paid_at_end,ReserveTimeVO vo,HttpSession session){
		Calendar mon = Calendar.getInstance();
		mon.add(Calendar.MONTH , -1);
	/*	String beforeMonth = new java.text.SimpleDateFormat("yyyy/MM/dd").format(mon.getTime());
		
		
		if(paid_at_start==null || paid_at_start.equals("") ) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(beforeMonth);
		}
		if(paid_at_end==null || paid_at_end.equals("") ) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}*/
		
		//李⑦듃 �뜲�씠�꽣
		String branchName = (String) session.getAttribute("branchName");
		/*List<RoomPaymentDTO> termSaleslist=prser.getTermSales(paid_at_start,paid_at_end);*/
		List<ReserveTimeVO> list2 = mgReserveTimeService.getreservcount(paid_at_start,paid_at_end,branchName);
		return list2;
		
	}
	
	
	
	@RequestMapping(value="/mgTime2.mdo",method=RequestMethod.POST)
	public  @ResponseBody ReserveTimeVO gettime(@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
			,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end,ReserveTimeVO vo,HttpSession session){
		
		if(paid_at_start==null || paid_at_start.equals("") ) {
			paid_at_start = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}
		if(paid_at_end==null || paid_at_end.equals("") ) {
			paid_at_end = new SimpleDateFormat("yy/MM/dd").format(new Date());
		}

		//由ъ뒪�듃
		List<ReserveTimeVO> list = mgReserveTimeService.mgAgeList(paid_at_start,paid_at_end);
		
		//�넻怨꾧퀎�궛
		mgReserveTimeService.mgsu(list,vo);
		
		return vo;
		
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
