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
	public @ResponseBody List<RoomInfoDTO> getSidoGugung(@RequestParam(value="sido" ,required=false,defaultValue="")String sel_sido,
														@RequestParam(value="gugun" ,required=false,defaultValue="")String sel_gugun,
														@RequestParam(value="seldate" ,required=false,defaultValue="")String sel_date,
														RoomInfoDTO romin
														){
		List<RoomInfoDTO> roomAllList=new ArrayList<RoomInfoDTO>();
		
		romin.setSidogugun(sel_sido+" "+sel_gugun);
		//시/도를 선택한 상태로 가져왔을 경우

		romin.setStartdate(sel_date);
		// 시 / 구 로 구별해서 가지고 옴
		System.out.println("여기까지 왔다 냥");
		roomAllList=roomser.getRoomInfoAndSchedule(romin);
		System.out.println("그다음 찍힌거다==>"+roomAllList.get(0).getFname());
			
		return roomAllList;
	}
}
