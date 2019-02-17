package com.study.luna.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.service.managerService;

@Controller
public class ManagerMainController {
	//����ȭ��
	
	@Autowired
	private managerService managerService;
	
	@RequestMapping(value="/manager.mdo", method=RequestMethod.GET)
	public ModelAndView mainView() {
		
		//�α��μ� +1;
		managerService.logincount();
		//�����
		//???
		
		//�α��� �� ��������(���� �α��� ����)
		int count = managerService.login();
		System.out.println("login :"+count);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("count",count);
		mv.setViewName("manager");
		
		return mv;
	} 
}
