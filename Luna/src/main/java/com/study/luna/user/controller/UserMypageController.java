package com.study.luna.user.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.user.alamandqa.service.AlamServiceImpl;
import com.study.luna.user.dto.AlamDTO;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.keeproom.service.RoomKeepService;
import com.study.luna.user.payandreserv.service.PayAndReserveService;
import com.study.luna.util.SHA256;

@Controller
public class UserMypageController {
	
	@Autowired
	MemberService memser;
	@Autowired
	PayAndReserveService parser;
	@Autowired
	AlamServiceImpl alser;
	@Autowired
	RoomKeepService rkser;
	
	@RequestMapping(value="/mypage.udo", method=RequestMethod.GET)
	public ModelAndView mypageView(AlamDTO alam,HttpSession session, MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		
		session.setAttribute("member", memcom);

		//마이페이지 최근 예약 정보 가져옴
		List<MyPageInfoDTO> mypReservInfo=new ArrayList<MyPageInfoDTO>();
		mypReservInfo=parser.getUserPayInfo(memcom);

		//지난 예약 정보 가져옴
		List<MyPageInfoDTO> myReservedInfo=new ArrayList<MyPageInfoDTO>();
		myReservedInfo=parser.getUserReservedInfo(memcom);
		
		//알림 정보 가져오기
		List<AlamDTO> myalam=new ArrayList<AlamDTO>();
		myalam=alser.getAlamlist(memcom);
		
		//찜리스트 가져오기
		List<RoomInfoDTO> keeplist=new ArrayList<RoomInfoDTO>();
		keeplist=rkser.getKeeplist(memcom.getId());
		
		
		memcom=memser.getMyPageInfo(memcom);
		mav.addObject("latelyreserInfo",mypReservInfo);
		mav.addObject("lastreserInfo",myReservedInfo);
		mav.addObject("alamlist",myalam);
		mav.addObject("keeplist",keeplist);
		mav.addObject("member",memcom);
		mav.setViewName("mypage");
		return mav;
	}
	
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
			romre.setStartdate(rompay.getReservdate());
			Integer sdresult=parser.checkReservStartdate(romre);
			
			//예약 테이블에 집어넣기
			romre.setReservstate(rompay.getReserveTime());
			
			System.out.println("눌른 스케줄==>"+romre.getReservstate());
			
			//row가 없으면 insert
			if(sdresult==null) {
				System.out.println("인서트 할꺼당"+romre.getStartdate());
				parser.inReserveRoom(romre);
			}else{//있으면 update
				System.out.println("업뎃 할꺼당"+romre.getStartdate());
				parser.upReserveRoom(romre);
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
