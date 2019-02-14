package com.study.luna.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserKakaopayController {
	@RequestMapping(value="/kakaopay.udo", method=RequestMethod.GET)
	public String kakaopayView() {
		return "kakaopay";
	}

	@RequestMapping(value="/kakaopay.udo", method=RequestMethod.POST)
	public ModelAndView kakaopayReady(HttpServletRequest req, HttpServletResponse res) {
		ModelAndView mav=new ModelAndView();
		/*
		  	msg += '고유ID : ' + rsp.imp_uid;
	        msg += '상점 거래ID : ' + rsp.merchant_uid;
	        msg += '결제 금액 : ' + rsp.paid_amount;
	        msg += '카드 승인번호 : ' + rsp.apply_num; 
		*/
		return mav;
	}
}