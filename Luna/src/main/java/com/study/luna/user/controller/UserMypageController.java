package com.study.luna.user.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@Transactional
	@RequestMapping(value="/mypage.udo", method=RequestMethod.POST)
	public ModelAndView mainView(@RequestParam(value="stat", required=false,defaultValue="")String stat,RoomReserveDTO romre,HttpServletRequest req,RedirectAttributes rdab,HttpSession session,MemberCommand memcom,RoomInfoDTO romin, RoomPaymentDTO rompay) throws Exception{
		ModelAndView mav=new ModelAndView();
		
		MemberCommand memcomID=(MemberCommand)session.getAttribute("member");
		memcom.setId(memcomID.getId());
		
		int paystatus=rompay.getStatus();
		
		if(paystatus==1) {
			//날짜로 변환
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			long unixTime = rompay.getPaid_ats();
			String formattedDtm = Instant.ofEpochSecond(unixTime).atZone(ZoneId.of("GMT-4")).format(formatter);
			rompay.setPaid_at(formattedDtm);
			
			//예약 테이블 확인
			romre.setRoomNum(romin.getRoomNum());
			
			if(rompay.getReserveEndTime()==""||rompay.getReserveEndTime()==null) {
				romre.setStartdate(rompay.getReservdate());
				romre.setReservstate(rompay.getReserveTime());
				Integer sdresult=parser.checkReservStartdate(romre);
			
				//row가 없으면 insert
				if(sdresult==null) {
					parser.inReserveRoom(romre);
				}else{//있으면 update
					romre.setReservNumber(sdresult);
					parser.upReserveRoom(romre);
				}
				
			}else{
				System.out.println("여기는 안냥이랍니다.====================================================================================================================>"+rompay.getReserveEndTime()+" " +rompay.getReservenddate());
				romre.setStartdate(rompay.getReservdate());
				romre.setReservstate(rompay.getReserveTime());
				Integer sdresult=parser.checkReservStartdate(romre);
				//row가 없으면 insert
				if(sdresult==null) {
					parser.inReserveRoom(romre);
				}else{//있으면 update
					romre.setReservNumber(sdresult);
					parser.upReserveRoom(romre);
				}
				romre.setStartdate(rompay.getReservenddate());
				romre.setReservstate(rompay.getReserveEndTime());
				Integer sdresult2=parser.checkReservStartdate(romre);
				
				//row가 없으면 insert
				if(sdresult2==null) {
					parser.inReserveRoom(romre);
				}else{//있으면 update
					romre.setReservNumber(sdresult2);
					parser.upReserveRoom(romre);
				}
			}
			rompay.setId(memcom.getId());
			parser.inRoomPayment(rompay);
			rompay.setStatus(0);
		}
			
		String pw=memcom.getPw();
		System.out.println("여기서의 pw"+pw+" 여기서 stat="+stat);
		if(stat.equals("1")) {
			System.out.println("비번 바뀜");
			SHA256 sha=SHA256.getInsatnce();
			String shaPass=sha.getSha256(memcom.getPw().getBytes());
			memcom.setPw(shaPass);
			memser.upUserInfo(memcom);
			memcom.setPw("");
		}else if(stat.equals("2")) {
			System.out.println("비번 안바뀜");
			memser.upUserInfo(memcom);
		}
		
		
		rdab.addFlashAttribute("id", memcom.getId());
		mav.setViewName("redirect:/mypage.udo");
		return mav;	
	}
}
