package com.study.luna.mg.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.mg.service.managerService;

@Controller
public class ManagerMainController {
	//메인화면
	
	@Autowired 
	private managerService managerService; 
	
	@RequestMapping(value="/manager.mdo", method=RequestMethod.GET)
	public ModelAndView mainView(HttpServletRequest request) {
		/*System.out.println("매니저 화면 호출 로그인 인증");
		System.out.println(request.getParameter("id")+"님");
		if(request.getParameter("id")==null || request.getParameter("id").equals("")) {
			System.out.println("매니저 인증 실패");
			return logincheck();
		}else {
			Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		    System.out.println("카카오 로그인==>"+flashMap.get("id"));
		}*/
		
		
		//로그인수 +1;
		managerService.logincount();
		//예약수  
		//???
		
		//로그인 수 가져오기(현재 로그인 수만)
		int count = managerService.login();
		System.out.println("login :"+count);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("count",count);
		mv.setViewName("manager");
		
		return mv;
	} 
	
	@RequestMapping(value="/loginX.mdo", method=RequestMethod.GET)
	public ModelAndView logincheck() {
		System.out.println("로그인 화면으로 이동");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/loginX");
		
		return mv;
	} 
	
	
}
