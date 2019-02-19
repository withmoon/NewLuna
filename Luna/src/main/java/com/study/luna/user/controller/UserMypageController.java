package com.study.luna.user.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;
import com.study.luna.util.SHA256;

@Controller
public class UserMypageController {
	
	@Autowired
	MemberService memser;
	@Autowired
	PayAndReserveService parser;
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.GET)
	public ModelAndView mypageView(HttpSession session, MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		session.setAttribute("member", memcom);
		
		memcom=memser.getMyPageInfo(memcom);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;
	}
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.POST)
	public ModelAndView mainView(RoomReserveDTO romre,HttpServletRequest req,RedirectAttributes rdab,HttpSession session,MemberCommand memcom,RoomInfoDTO romin, RoomPaymentDTO rompay) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		MemberCommand memcomID=(MemberCommand)session.getAttribute("member");
		memcom.setId(memcomID.getId());
		
		int paystatus=rompay.getStatus();
		
		if(paystatus==1) {
			//날짜로 변환
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			long unixTime = rompay.getPaid_ats();
			String formattedDtm = Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT-4")).format(formatter);
			rompay.setPaid_at(formattedDtm);
			
			//예약 테이블 확인
			romre.setReservstate(formattedDtm);
			romre.setRoomNum(romin.getRoomNum());
			int sdresult=parser.checkReservStartdate(romre);
			
			//예약 테이블에 집어넣기
			romre.setReservstate(rompay.getReserveTime());
			
			System.out.println(romre.getReservstate());
			
			//row가 없으면 insert
			if(sdresult==0) {
				//예약 집어넣기
				
			}else{//있으면 update
				
			}
			
			rompay.setStatus(0);
		}
			
		String pw=memcom.getPw();
		if(pw!=null) {
			System.out.println("너가 왜 여기있냐..");
			SHA256 sha=SHA256.getInsatnce();
			String shaPass=sha.getSha256(memcom.getPw().getBytes());
			memcom.setPw(shaPass);
			memser.upUserInfo(memcom);
		}
		
		rdab.addFlashAttribute("id", memcom.getId());
		mav.setViewName("redirect:/mypage.udo");
		return mav;	
	}
}
