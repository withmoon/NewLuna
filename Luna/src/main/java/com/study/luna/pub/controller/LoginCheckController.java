package com.study.luna.pub.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class LoginCheckController {
	
	@Autowired
	MemberService memser;
	
	@RequestMapping(value = "login/loginCheck.do", method = RequestMethod.POST)
	public ModelAndView idCehcklogin(RedirectAttributes rdab,MemberCommand memcom, @RequestParam("id") String id,@RequestParam("pw") String pass, HttpServletResponse response)throws Exception {
		ModelAndView mav=new ModelAndView();
		memcom.setId(id);
		int result = memser.idCheck(memcom);
		if (result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('등록되지 않은 아이디거나, 아이디나 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
			out.flush();
		}else {
			boolean check=memser.passCheck(id, pass);
			if(check) {
				rdab.addFlashAttribute("id", memcom.getId());
				mav.setViewName("redirect:/log/home.udo");
				return mav;
			}else { //안맞으면 돌려보냄
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				out.println("<script>alert('등록되지 않은 아이디거나, 아이디나 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
				out.flush();
			}
		}
		return null;
	}
}
