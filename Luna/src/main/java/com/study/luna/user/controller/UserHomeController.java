package com.study.luna.user.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;
import com.study.luna.user.payandreserv.service.PayAndReserveService;
import com.study.luna.user.review.service.RoomReviewService;
import com.study.luna.user.room.service.RoomService;
import com.study.luna.util.SHA256;

@Controller
public class UserHomeController {
	
	@Autowired
	MemberService memser;
	@Autowired
	RoomService roomser;
	@Autowired
	PayAndReserveService parser;
	@Autowired
	RoomReviewService rrvser;

	//카카오로그인
	@RequestMapping(value="kakao/home.udo", method=RequestMethod.GET)
	public ModelAndView homeViewtget(RedirectAttributes rdab,MemberCommand memcom,HttpServletRequest request) {
		ModelAndView mav=new ModelAndView();
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		memcom.setId(flashMap.get("id").toString());
		
		rdab.addFlashAttribute("id", memcom.getId());
		
		mav.setViewName("redirect:/home.udo");
		return mav;
	}
	
	//회원가입 로그인
	@RequestMapping(value="/join/home.udo", method=RequestMethod.POST)
	public ModelAndView homeloginView(HttpServletResponse response,RedirectAttributes rdab,MemberCommand memcom,@RequestParam(value="kid",required=false,defaultValue="") String kid, @RequestParam(value="knic",required=false,defaultValue="") String knic) throws Exception {
		ModelAndView mav=new ModelAndView();
		int result =0;
		if(kid.equals("")) {
			result= memser.idCheck(memcom);
		}
		if (result == 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('중복된 아이디 입니다. 아이디 입력후 중복체크를 해주세요'); history.go(-1);</script>");
			out.flush();
			return null;
		}
		
		if(!kid.equals("")) { //카카오 로그인시
			memcom.setKid(kid);
			memcom.setPw(knic);
		}
		memcom.setBranchAddr2(memcom.getBranchAddr2()+"#"+memcom.getBranchAddr3());
		//비번 암호화
		SHA256 sha=SHA256.getInsatnce();
		String shaPass=sha.getSha256(memcom.getPw().getBytes());
		memcom.setPw(shaPass);
		
		//회원가입
		memser.insertMember(memcom);
		
		String branchName=memcom.getBranchName();
		if(kid.equals("")) {
			rdab.addFlashAttribute("id", memcom.getId());
		}else {
			rdab.addFlashAttribute("id", memcom.getKid());
		}
		//회원은 회원으로 
		if(branchName==null) {
			System.out.println("홈에서 아이디==>"+memcom.getId());
			mav.setViewName("redirect:/home.udo");
			return mav;
		}else{ //지점장 회원가입시 alert띄우고 메인으로 돌아옴
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			out.println("<script>alert('지점장 등록이 완료되셨습니다. 승인이 완료되면 이메일로 알려드리겠습니다.'); window.location='/luna/main.do'; </script>");
			out.flush();
		}
		return null;
	}
	
	//일반 로그인
	@RequestMapping(value="/home.udo", method=RequestMethod.GET)
	public ModelAndView homeView(MemberCommand memcom,HttpServletRequest request,HttpSession session) throws Exception {
		ModelAndView mav=new ModelAndView();
	
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
			
		session.setAttribute("member", memcom);
		
		List<String> sido=roomser.getSido();
		Integer allBranchCount=memser.allBranchCount();
		Integer allMemberCount=memser.allMemberCount();
		Integer preYearReserveCount=parser.getPreYearReserveCount();
		Integer thisYearReserveCount=parser.getThisYearReserveCount();
		Integer preDayReserveCount=parser.getPreDayReserveCount();
		Integer preMonthReserveCount=parser.getPreMonthReserveCount();
		
		
		
		mav.addObject("sido",sido);
		mav.addObject("allMemberCount",allMemberCount);
		mav.addObject("allBranchCount",allBranchCount);
		mav.addObject("preYearReserveCount",preYearReserveCount);
		mav.addObject("thisYearReserveCount",thisYearReserveCount);
		mav.addObject("preDayReserveCount",preDayReserveCount);
		mav.addObject("preMonthReserveCount",preMonthReserveCount);
		mav.addObject("member",session.getAttribute("member"));
		mav.setViewName("home");
		return mav;
	}
}