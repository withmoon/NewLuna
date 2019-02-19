package com.study.luna.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.RoomFileDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.room.service.RoomService;

@Controller
public class UserRoomDetailController {
	
	@Autowired
	RoomService romser;
	
	@RequestMapping(value = "/roomDetail.udo", method = RequestMethod.GET)
	public ModelAndView roomDetailView(@RequestParam(value="roomnum",required=false,defaultValue="")int roomnum,
			@RequestParam(value="seldate",required=false,defaultValue="")String seldate,
			RoomInfoDTO roomin,MemberCommand memcom,RoomPaymentDTO roomPay,RoomReserveDTO romre, HttpSession session)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		memcom = (MemberCommand) session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		roomin.setRoomNum(roomnum);
		roomin=romser.getDetailRoomInfo(roomin);
		
		List<RoomFileDTO> roomImgList=romser.getRoomAllimg(roomnum);
		
		mav.addObject("roomPay",roomPay);
		mav.addObject("roomInfo",roomin);
		mav.addObject("roomImgList",roomImgList);
		mav.addObject("sel_date",seldate);
		mav.addObject("romre",romre);
		mav.addObject("member", session.getAttribute("member"));
		mav.setViewName("roomDetail");
		return mav;
	}
}
