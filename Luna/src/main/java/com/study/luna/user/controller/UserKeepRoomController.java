package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.keeproom.service.RoomKeepService;

@Controller
public class UserKeepRoomController {
	@Autowired
	RoomKeepService rkser;
	
	@RequestMapping("/changekeeproom.udo")
	public @ResponseBody void changekeeproom(HttpSession session,MemberCommand memcom, KeepRoomDTO krd,
			@RequestParam("roomnum")int roomnum, @RequestParam("kst") int kst) {
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		krd.setId(memcom.getId());
		krd.setRoomnum(roomnum);
		if(kst==0) {
			rkser.deletekroom(krd);
		}else {
			rkser.keeproom(krd);
		}
	}
	
}
