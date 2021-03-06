package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.service.RoomServiceImpl;

@Controller
public class UserGetCanReservRoomController {
	@Autowired
	RoomServiceImpl roomser;

	@RequestMapping(value="/getCanReservRoom.udo")
	public @ResponseBody List<RoomInfoDTO> getCanReservRoom(@RequestParam(value="sido" ,required=false,defaultValue="")String sel_sido,
														@RequestParam(value="gugun" ,required=false,defaultValue="")String sel_gugun,
														@RequestParam(value="seldate" ,required=false,defaultValue="")String sel_date,
														RoomInfoDTO romin
														){
		List<RoomInfoDTO> roomAllList=new ArrayList<RoomInfoDTO>();
		
		romin.setSidogugun(sel_sido+" "+sel_gugun);
		romin.setStartdate(sel_date);
		
		roomAllList=roomser.getAllRoomInfo(romin);

		return roomAllList; 
	}
	
	@RequestMapping(value="/getSchedule.udo")
	public @ResponseBody RoomInfoDTO getSchedule(@RequestParam(value="roomnum" ,required=false,defaultValue="")int roomnum,
											@RequestParam(value="seldate" ,required=false,defaultValue="")String sel_date,
			RoomInfoDTO romin){
		romin.setStartdate(sel_date);
		romin.setRoomNum(roomnum);

		romin=roomser.getRoomSchedule(romin);

		return romin;
	}
}
