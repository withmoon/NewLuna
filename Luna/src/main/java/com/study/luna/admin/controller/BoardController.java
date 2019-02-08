package com.study.luna.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminQnABoardVO;

@Controller
public class BoardController {    
    @Inject
      AdminQnABoardService adminQnABoardService;
    
    @RequestMapping(value = "/board.ado")
      public ModelAndView list()throws Exception{ 
      List<AdminQnABoardVO> list = adminQnABoardService.listAll(); 
      ModelAndView mav= new ModelAndView();
      mav.setViewName("boardList");
      Map<String,Object> map = new HashMap<>();
      map.put("list",list);
      mav.addObject("map",map);
      return mav;
      }
}