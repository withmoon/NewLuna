package com.study.luna.user.controller;

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
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.dto.RoomFileDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.keeproom.service.RoomKeepService;
import com.study.luna.user.room.service.RoomService;

@Controller
public class UserRoomDetailController {
	
	@Autowired
	RoomService romser;
	@Autowired
	RoomKeepService rkser;
	
	@RequestMapping(value = "/roomDetail.udo", method = RequestMethod.GET)
	public ModelAndView roomDetailView(@RequestParam(value="roomnum",required=false,defaultValue="")int roomnum,
			@RequestParam(value="seldate",required=false,defaultValue="")String seldate,
			KeepRoomDTO krd,RoomInfoDTO roomin,MemberCommand memcom,RoomPaymentDTO roomPay,RoomReserveDTO romre, HttpSession session,HttpServletRequest request)
			throws Exception {
		
		ModelAndView mav = new ModelAndView();
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
			
		session.setAttribute("member", memcom);
		//여까지 고침
		
		roomin.setRoomNum(roomnum);
		roomin=romser.getDetailRoomInfo(roomin);
		
		List<RoomFileDTO> roomImgList=romser.getRoomAllimg(roomnum);
		
		//Optional<MemberCommand> maybeMember = Optional.ofNullable(memcom);
		Integer keepstate=0;
		if(memcom!=null) {
			krd.setId(memcom.getId());
			krd.setRoomnum(roomnum);
			keepstate=rkser.getKeepStatus(krd);
		}
		
		mav.addObject("roomPay",roomPay);
		mav.addObject("roomInfo",roomin);
		mav.addObject("keepstate",keepstate);
		mav.addObject("roomImgList",roomImgList);
		mav.addObject("sel_date",seldate);
		mav.addObject("romre",romre);
		mav.addObject("member", session.getAttribute("member"));
		mav.setViewName("roomDetail");
		return mav;
	}
}
