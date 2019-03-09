package com.study.luna.pub.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.GetMemberPositionService;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class LoginCheckController {
	
	@Autowired
	MemberService memser;
	@Autowired
	GetMemberPositionService getMemberPositionService;
	
	@RequestMapping(value = "login/loginCheck.do", method = RequestMethod.POST)
	public ModelAndView idCehcklogin(HttpSession session,RedirectAttributes rdab,MemberCommand memcom, @RequestParam("id") String id,@RequestParam("pw") String pass, HttpServletResponse response)throws Exception {
		ModelAndView mav=new ModelAndView();
		memcom.setId(id);
		//아이디 존재 여부 확인
		int result = memser.idCheck(memcom);
		if (result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('등록되지 않은 아이디거나, 아이디나 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
			out.flush();
		}else {
			//로그인 상태 체크
			int status=memser.getStatus(memcom);

			if(status==-1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				out.println("<script>alert('승인 되지 않은 아이디입니다.'); history.go(-1);</script>");
				out.flush();
			}else if(status==-2){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				out.println("<script>alert('탈퇴된 회원입니다. 문의사항은 이메일로 보내주세기 바랍니다.'); history.go(-1);</script>");
				out.flush();
			}else {
				boolean check=memser.passCheck(id, pass);
				if(check) {
					String position=getMemberPositionService.getMemberPosition(id);
					rdab.addFlashAttribute("id", memcom.getId());
					//사용자가 접속했던 곳으로 리턴해줌
					String redirectUrl=(String)session.getAttribute("rdUrl");
					if(position==null) {
						mav.setViewName("redirect:"+redirectUrl);
						return mav;
					}else if(position.equals("지점장")) {
						mav.setViewName("redirect:/manager.mdo");
						return mav;
					}else {
						mav.setViewName("redirect:/admin.ado");
						return mav;
					}
				}else { //비번 안맞으면 돌려보냄
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					response.setCharacterEncoding("utf-8");
					out.println("<script>alert('등록되지 않은 아이디거나, 아이디나 비밀번호가 틀렸습니다.'); history.go(-1);</script>");
					out.flush();
				}
			}
		}
		return null;
	}
}
