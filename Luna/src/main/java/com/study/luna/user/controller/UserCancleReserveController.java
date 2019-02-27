package com.study.luna.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;

@Controller
public class UserCancleReserveController {
	@Autowired
	PayAndReserveService parser;
	
	@RequestMapping(value="/cancleReserve.udo", method=RequestMethod.POST)
	public @ResponseBody void cancleReserve(MyPageInfoDTO mpif,@RequestParam("imp_uid")String imp_uid){
		mpif.setImp_uid(imp_uid);
		parser.cancleReserve(mpif);
	}
}
