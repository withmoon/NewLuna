package com.study.luna.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Controller
public class AdminQnABoardWriteController {

   @Inject
   AdminQnABoardService adminQnABoardService;


   
   @RequestMapping(value = "/qnaupdate.ado" ,method=RequestMethod.POST)
   public String View(@ModelAttribute AdminQnABoardVO vo)throws Exception{
      adminQnABoardService.update(vo);  
   return "redirect:/boardList.ado";
   }
   
   @RequestMapping(value = "/qnadelete.ado")
   public String deleteView(@RequestParam int num)throws Exception{
      adminQnABoardService.delete(num);  
   return "redirect:/boardList.ado";
   }
   
   
   @RequestMapping(value = "/write.ado", method = RequestMethod.GET)
   public String mainView() {
      return "write";
   }
   
   @RequestMapping(value = "/qnaview.ado", method = RequestMethod.GET)
   public ModelAndView view(@RequestParam int num) throws Exception {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("qnaview");
      mav.addObject("num",adminQnABoardService.read(num));
      return mav;
   }
   
   
   /*@RequestMapping(value = "/boardList.ado")
   public ModelAndView list()throws Exception{ 
   List<AdminQnABoardVO> list = adminQnABoardService.listAll(); 
   ModelAndView mav= new ModelAndView();
   mav.setViewName("boardList");
   Map<String,Object> map = new HashMap<>();
   map.put("list",list);
   mav.addObject("map",map);
   return mav;
   }*/
   
   @RequestMapping(value = "/insert.ado")
   public String insert(@ModelAttribute AdminQnABoardVO adminQnABoardVO) throws Exception {
      adminQnABoardService.insert(adminQnABoardVO);
      return "redirect:/boardList.ado";
   }
   
}