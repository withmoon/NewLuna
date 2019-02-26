package com.study.luna.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.keeproom.service.RoomKeepService;
@Controller
public class UserKeepListController {
	@Autowired
	RoomKeepService rkser;
	

	@RequestMapping(value="/keeproomlist.udo",method=RequestMethod.GET) 
	public @ResponseBody JSONObject changekeeproom(HttpSession session,MemberCommand memcom, KeepRoomDTO krd,
																		@RequestParam(value="curpage",defaultValue = "1") int curPage) {
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		int count = rkser.getKeepCount(memcom.getId());
		
		int page_scale = 4;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager keepPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = keepPager.getPageBegin();
		int end = keepPager.getPageEnd();

		List<RoomInfoDTO> list = rkser.getKeeplist(start, end, memcom.getId());
		
		JSONObject obj = new JSONObject();
		obj.put("klist", list);
		obj.put("kpager", keepPager);
		return obj;
	}
}
