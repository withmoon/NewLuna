package com.study.luna.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class MemberController {
   @Autowired
   MemberService memberService;
   
   //1. 회원 목록
   @RequestMapping(value="/member.ado", method=RequestMethod.GET)
    public ModelAndView mainView(MemberCommand mc) {
      List<MemberCommand> memberList = memberService.memberList(mc);
      ModelAndView mav = new ModelAndView();
      mav.addObject("memberList", memberList);
      
       return mav;
   }
   
}