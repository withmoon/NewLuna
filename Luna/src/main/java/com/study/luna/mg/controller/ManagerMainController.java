package com.study.luna.mg.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.mg.DAO.managerDAO;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.StatisticsVO;
import com.study.luna.mg.service.managerService;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class ManagerMainController {
   // 
   
   @Autowired
   private managerService managerService;
   
   @Autowired
   private managerDAO managerDAO; 
   

   @Autowired
   MemberService memser;

   @RequestMapping(value = "/manager.mdo", method = RequestMethod.GET)
   public ModelAndView mainView(HttpServletRequest request, Map<String, ?> flashMap, HttpSession session,QBoardVO vo)
         throws Exception {
      System.out.println("로그인 아이디  받아오기");
      System.out.println("test 세션 :"+session.getAttribute("id"));
      if ((flashMap.get("id") == null || flashMap.get("id").equals("")) && session.getAttribute("id") == null) {
         System.out.println("카카오 로그인 실패");
         return logincheck();
      }else if(!session.getAttribute("id").equals(null)){
         System.out.println("세션에서 매니저ID 확인");
         
         String id=(String) session.getAttribute("id");
         String bn = managerService.branchname(id); //지점 검색
         System.out.println("branchName :" +bn.toString());
         session.setAttribute("branchName",bn);
         System.out.println("세션:" +session.getAttribute("branchName"));
      }else {
         flashMap = RequestContextUtils.getInputFlashMap(request);
         System.out.println("카카오 로그인 ==>" + flashMap.get("id"));
         session.setAttribute("id", flashMap.get("id"));
         String id=(String) session.getAttribute("id");
         
         String bn = managerService.branchname(id); //지점 검색
         System.out.println("branchName :" +bn);
         session.setAttribute("branchName",bn);
      
      }
        
      //게시글 모든 정보 가져오기
      List<QBoardVO> list = managerDAO.board();

      Calendar calendar = Calendar.getInstance();    
      
      //이번달 ㅁㄴㅇㅁ
      int year = calendar.get( Calendar.YEAR );
        int month  = calendar.get(calendar.MONTH) + 1;
        String days = year+"/"+month;
        System.out.println(days);
      
        //회원수 가져오기 
        int member = managerService.member();
      //환불수 가져오기
        int reroom = managerDAO.reroom();
      //방문자 수 가져오기 (로그인만 - 로그인컨트롤러에서 처리할것들)
      int login= managerService.login();
      //예약수 
      int roomcount= managerService.roomcount(session,days);
      //회원가입수
      int joincount =managerService.join();
      
//      List<RoomPaymentDTO> test = PayAndReserveService.getTermSales();
      
      
      Map<String, Object> map = new HashMap<>();
      map.put("login", login);
      map.put("room", roomcount);
      map.put("joincount", joincount);
      map.put("member", member);
      map.put("reroom", reroom);
      map.put("list", list);
      ModelAndView mv = new ModelAndView();
      mv.addObject("map", map);
      mv.setViewName("manager");


      return mv;
   }
/*
   @RequestMapping(value = "/manager.mdo", method = RequestMethod.POST)
   public ModelAndView mainView() {

      // 로그인 수 가져오기 (로그인만 - 로그인컨트롤러에서 처리할것들)
      int count = managerService.login();
      System.out.println("login :" + count);

      ModelAndView mv = new ModelAndView();
      mv.addObject("count", count);
      mv.setViewName("manager");

      return mv;
   }*/

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
      session.invalidate();
      mav.setViewName("redirect:/home.udo");
      return mav;
   }

}