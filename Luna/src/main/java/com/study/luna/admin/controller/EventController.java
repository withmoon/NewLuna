package com.study.luna.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminEventBoardService;
import com.study.luna.admin.model.vo.AdminEventBoardVO;


@Controller
public class EventController {
   
    @Inject
    AdminEventBoardService adminEventBoardService;
    
    @RequestMapping(value="/event.ado", method=RequestMethod.GET)
     public String mainView() {
        return "event";
}
}
    
    
 