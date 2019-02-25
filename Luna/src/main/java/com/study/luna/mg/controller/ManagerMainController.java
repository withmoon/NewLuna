package com.study.luna.mg.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.mg.service.managerService;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class ManagerMainController {
	// ����ȭ��

	@Autowired
	private managerService managerService;

	@Autowired
	MemberService memser;

	@RequestMapping(value = "/manager.mdo", method = RequestMethod.GET)
	public ModelAndView mainView(HttpServletRequest request, Map<String, ?> flashMap, HttpSession session)
			throws Exception {
		System.out.println("로그인 아이디  받아오기");
		System.out.println("test 세션 :"+session.getAttribute("id"));
		if ((flashMap.get("id") == null || flashMap.get("id").equals("")) && session.getAttribute("id") == null) {
			System.out.println("카카오 로그인 실패");
			return logincheck();
		}else if(!(session.getAttribute("id")==null)){
			System.out.println("세션에서 매니저ID 확인");
		}else {
			flashMap = RequestContextUtils.getInputFlashMap(request);
			System.out.println("카카오 로그인 ==>" + flashMap.get("id"));
			session.setAttribute("id", flashMap.get("id"));
			
			// 로그인수+1
			managerService.logincount();
			// 예약수
			// ???
		}

		// 로그인 수 가져오기 (로그인만 - 로그인컨트롤러에서 처리할것들)
		int count = managerService.login();
		System.out.println("login :" + count);

		ModelAndView mv = new ModelAndView();
		mv.addObject("count", count);
		mv.setViewName("manager");

		return mv;
	}

	@RequestMapping(value = "/manager.mdo", method = RequestMethod.POST)
	public ModelAndView mainView() {

		// 로그인 수 가져오기 (로그인만 - 로그인컨트롤러에서 처리할것들)
		int count = managerService.login();
		System.out.println("login :" + count);

		ModelAndView mv = new ModelAndView();
		mv.addObject("count", count);
		mv.setViewName("manager");

		return mv;
	}

	// 매니저 인증 실패시
	@RequestMapping(value = "/loginX.mdo", method = RequestMethod.GET)
	public ModelAndView logincheck() {
		System.out.println("매니저 인증 실패 로그인화면으로 이동");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/loginX");

		return mv;
	}

	@RequestMapping("/logout.mdo")
	public ModelAndView logout(MemberCommand memcom, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		memcom.setId((String) session.getAttribute("id"));
		System.out.println(memcom);
		memser.dnStatus(memcom);
		session.invalidate();
		mav.setViewName("redirect:/home.udo");
		return mav;
	}

}
