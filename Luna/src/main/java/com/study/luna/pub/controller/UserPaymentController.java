package com.study.luna.pub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserPaymentController {
	
	@RequestMapping(value="/payment.udo", method=RequestMethod.POST)
	public ModelAndView kakaopayReady(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav=new ModelAndView();
		System.out.println("실례하겠씁다!~");
		String id=req.getParameter("imp_uid");
		String payid=req.getParameter("merchant_uid");
		String payAmount=req.getParameter("paid_amount");
		String apply_num=req.getParameter("apply_num");
		System.out.println(id+" "+payid+" "+payAmount+" "+apply_num);
		/*
		  	msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num; 
		*/
		mav.setViewName("redirect:/mypage.udo");
		return mav;
	}
	
}
