package com.study.luna.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;

@Controller
public class UserCancleReserveController {
	@Autowired
	PayAndReserveService parser;
	
	@RequestMapping(value="/cancleReserve.udo", method=RequestMethod.POST)
	public @ResponseBody void cancleReserve(MemberCommand memcom,HttpSession session,MyPageInfoDTO mpif,@RequestParam("id")String id,@RequestParam("imp_uid")String imp_uid){
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		mpif.setId(memcom.getId());
		mpif.setStatus(-2);
		mpif.setImp_uid(imp_uid);
		parser.cancleReserve(mpif);
		
		System.out.println(mpif.getId()+"끝나고 들어왔냐"+mpif.getImp_uid());
	}
}
