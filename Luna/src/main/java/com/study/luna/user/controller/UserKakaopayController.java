package com.study.luna.user.controller;

import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserKakaopayController {
	@RequestMapping(value="/kakaopay.udo", method=RequestMethod.GET)
	public String kakaopayView() {
		return "kakaopay";
	}

	@RequestMapping(value="/kakaopayReady.udo", method=RequestMethod.POST)
	public String kakaopayReady() {
			String token="4148808bd5ab3e6b2b6709e3160815b6";
			String header="Bearer "+token;
		try {
			String readyPayURL="https://kapi.kakao.com/v1/payment/ready";
			URL url=new URL(readyPayURL);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return "kakaopay";
	}
}
