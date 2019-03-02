package com.study.luna.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.member.service.Impl.MemberServiceImpl;

@Controller
public class UserGetBranchNameController {
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping(value="/branchName.udo")
	public @ResponseBody List<String> branchName(@RequestParam(value="undefined", defaultValue="서초구")String gugun, HttpSession session){
		//RoomInfoDTO room= (RoomInfoDTO) session.getAttribute("room");
		
		List<String> branchList = memberService.branchList(gugun);
		return branchList;
	}
}
