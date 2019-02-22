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

import com.study.luna.admin.board.service.AdminInquireBoardService;
import com.study.luna.admin.model.vo.AdminInquireBoardVO;

@Controller
public class AdminInquireController {

	@Inject
	AdminInquireBoardService service;

	 @RequestMapping(value = "/inquireinsert.ado" ,method=RequestMethod.POST)
	    public String insert(@ModelAttribute AdminInquireBoardVO vo) throws Exception {
	    	service.inquireinsert(vo);
	       return "redirect:/inquireList.ado";
	    }   
	
	@RequestMapping(value = "/inquire.ado")
	public String view() {
		return "redirect:/inquireList.ado";
	}

	@RequestMapping(value = "/inquirewrite.ado")
	public ModelAndView views(@RequestParam Integer seq)throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inquirewrite");
		mav.addObject("seq",service.inquireread(seq));
		return mav;
	}
	
	@RequestMapping(value = "/inquireList.ado")
	public ModelAndView list() throws Exception {
		List<AdminInquireBoardVO> list = service.inquireList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inquireList");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		mav.addObject("map", map);
		return mav;
	}
}
