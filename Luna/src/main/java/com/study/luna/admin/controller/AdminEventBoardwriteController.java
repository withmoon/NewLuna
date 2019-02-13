package com.study.luna.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;



@Controller
public class AdminEventBoardwriteController {
   
   @Inject 
    AdminEventBoardService adminEventBoardService;
   
   @RequestMapping(value = "/insert1.ado", method = RequestMethod.POST)
      public String insert(@ModelAttribute AdminEventBoardVO adminEventBoardVO) throws Exception {

      adminEventBoardService.insert(adminEventBoardVO);
         return "redirect:/eventlist.ado";
      }
   
   
     @RequestMapping(value="/eventwrite.ado", method=RequestMethod.GET)
      public String mainView() {
         return "eventwrite";
     }

         
         @RequestMapping(value = "/eventlist.ado")
         public ModelAndView listAll()throws Exception{ 
         List<AdminEventBoardVO> list = adminEventBoardService.listAlls(); 
         ModelAndView mav= new ModelAndView();
         mav.setViewName("eventlist");
         Map<String,Object> map = new HashMap<>();
         map.put("list",list);
         mav.addObject("map",map);
         return mav;
   }
}