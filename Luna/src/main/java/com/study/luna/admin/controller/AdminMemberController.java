package com.study.luna.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class AdminMemberController {
   @Autowired
   MemberService memberService;
   
   @RequestMapping(value="/member.ado", method=RequestMethod.GET)
    public String mainView() {
	   return "member";
   }
   
   //1. 회원 목록
   @RequestMapping(value="/aMemberList.ado", method=RequestMethod.GET)
    public @ResponseBody JSONObject aMemberList(@RequestParam(defaultValue="1") int curPage,
    											MemberCommand mc, HttpSession session) {
	//페이징 처리
   	int count = memberService.countMember(mc.getId());
   			
   	int page_scale = 10; // 페이지당 게시물 수
   	int block_sclae = 5; // 화면당 페이지 수
   	// 페이지 나누기처리 
   	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

   	int start = boardPager.getPageBegin();
   	int end = boardPager.getPageEnd();
   	
    List<MemberCommand> memberList = memberService.memberList(start, end, session);
    
    JSONObject obj = new JSONObject();

  	obj.put("memberList", memberList);
  	obj.put("memberPage", boardPager);
  	return obj;
   }
   
   
   //회원 제명
   @RequestMapping(value="/remove.ado")
   public String removedelete(String id)throws Exception{
      //memberService.removedelete(id);
	   
      return "redirect:/member.ado";
   }
   
}