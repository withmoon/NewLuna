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
	//����ȭ��
	
	@Autowired 
	private managerService managerService; 
	
	@RequestMapping(value="/manager.mdo", method=RequestMethod.GET)
	public ModelAndView mainView(HttpServletRequest request) {
		/*System.out.println("�Ŵ��� ȭ�� ȣ�� �α��� ����");
		System.out.println(request.getParameter("id")+"��");
		if(request.getParameter("id")==null || request.getParameter("id").equals("")) {
			System.out.println("�Ŵ��� ���� ����");
			return logincheck();
		}else {
			Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		    System.out.println("īī�� �α���==>"+flashMap.get("id"));
		}*/
		
		
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
	
	@RequestMapping(value="/loginX.mdo", method=RequestMethod.GET)
	public ModelAndView logincheck() {
		System.out.println("�α��� ȭ������ �̵�");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/loginX");
		
		return mv;
	} 
	
	
}
