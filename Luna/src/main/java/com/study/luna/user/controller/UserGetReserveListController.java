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
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;

@Controller
public class UserGetReserveListController {
	@Autowired
	PayAndReserveService parser;
	
	@RequestMapping(value="/getReserveList.udo",method=RequestMethod.GET) 
	public @ResponseBody JSONObject changekeeproom(MemberCommand memcom,HttpSession session,
			@RequestParam(value="listType",defaultValue = "1") String listType,@RequestParam(value="curpage",defaultValue = "1") int curPage,
			@RequestParam(value="startdate",required=false, defaultValue = "") String startdate,@RequestParam(value="enddate",required=false,defaultValue = "") String enddate) {
		
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);

		Integer count=parser.getUserPayCount(listType, memcom.getId(),startdate,enddate);
		System.out.println("칸트"+count);
		int page_scale=0;
		int block_sclae=0;
		if(listType.equals("pay")) {
			page_scale= 3;
			block_sclae = 5;
		}else {
			page_scale = 5;
			block_sclae = 3;
		}
		// 페이지 나누기처리 
		BoardPager rvPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = rvPager.getPageBegin();
		int end = rvPager.getPageEnd();

		List<MyPageInfoDTO> mypReservInfo=parser.getUserPayInfo(start, end, listType, memcom.getId(),startdate,enddate);
		System.out.println("마이리스트사이즈"+mypReservInfo.size());
		JSONObject obj = new JSONObject();
		obj.put("rvlist", mypReservInfo);
		obj.put("rvpager", rvPager);
		return obj;
	}
}
