package com.study.luna.pub.member.controller;

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
import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.member.service.GetAllMemberCountService;
import com.study.luna.pub.member.service.GetAllMemberService;

@Controller
public class GetAllMemberController {
	@Autowired
	GetAllMemberService getAllMemberService;
	@Autowired
	GetAllMemberCountService getAllMemberCountService;
	
	@RequestMapping(value="/getAllMember.do", method=RequestMethod.POST)
	public @ResponseBody JSONObject getAllMember(ReportDTO rpd,HttpSession session,@RequestParam("curPage") int curPage,
			@RequestParam(value="searchOption",required=false,defaultValue="") String searchOption,
			@RequestParam(value="keyword",required=false,defaultValue="") String keyword){
		//MemberCommand memcom=(MemberCommand)session.getAttribute("member");
		//session.setAttribute("member", memcom);

		System.out.println("내가 받아ㅗ아따 " +searchOption+" " +keyword+"=============================================================================================================>");
	

		Integer count = getAllMemberCountService.getAllMemberCount(searchOption, keyword);
		
		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		List<MemberCommand> memberlist=getAllMemberService.getAllMember(start,end,searchOption, keyword);

		JSONObject obj = new JSONObject();
		obj.put("memberList", memberlist);
		obj.put("memberPage", pager);
		return obj;
	}
}
