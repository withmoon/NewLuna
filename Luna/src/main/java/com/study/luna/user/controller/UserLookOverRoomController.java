package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.service.RoomService;

@Controller
public class UserLookOverRoomController {
	
	@Autowired
	RoomService roomser;
	
	@RequestMapping(value="/lookover.udo", method=RequestMethod.GET)
	public ModelAndView lookOverView(@RequestParam(value="sido",required=false,defaultValue="")String sel_sido,
										@RequestParam(value="gugun",required=false,defaultValue="")String sel_gugun,RoomInfoDTO romin) {
		ModelAndView mav=new ModelAndView();

		List<String> sido=roomser.getSido();
		List<String> gugun=new ArrayList<String>();
		if(!sel_sido.equals("")) {
			gugun=roomser.getGugun(sel_sido);
		}
		
		List<RoomInfoDTO> roomAllList=roomser.getRoomInfo(romin);
		//RoomInfoDTO rom=roomAllList.get(0);
		
		//System.out.println("받아온 방의 갯수===>"+rom.getRoomName());
		mav.addObject("roomList",roomAllList);
		
		mav.addObject("sido",sido);
		mav.addObject("gugun",gugun);
		mav.addObject("sel_sido",sel_sido);
		mav.addObject("sel_gugun",sel_gugun);
		mav.setViewName("lookover");
		return mav;
	}
	
	
}
