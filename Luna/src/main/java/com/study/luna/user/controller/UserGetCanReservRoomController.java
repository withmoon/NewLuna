package com.study.luna.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.room.service.RoomServiceImpl;

@Controller
public class UserGetCanReservRoomController {
	@Autowired
	RoomServiceImpl roomser;

	@RequestMapping(value="/getCanReservRoom.udo")
	public @ResponseBody List<String> getSidoGugung(@RequestParam(value="sido" ,required=false,defaultValue="")String sido,
														@RequestParam(value="gugun" ,required=false,defaultValue="")String gugun,
														@RequestParam(value="seldate" ,required=false,defaultValue="")String seldate){
		System.out.println("현재 지역 ===>"+sido);
		System.out.println("현재 구군===>"+gugun);
		System.out.println("선택한 날짜===>"+seldate);
		List<String> list=roomser.getGugun(sido);
		return list;
	}
}
