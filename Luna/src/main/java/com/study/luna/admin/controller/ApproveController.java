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

import com.study.luna.admin.board.service.AdminManagerApproveService;
import com.study.luna.admin.model.vo.AdminManagerApproveVO;


@Controller
public class ApproveController {
	
	@Inject
	AdminManagerApproveService adminManagerApproveService;
	
	
	@RequestMapping(value="/approvedelete.ado")
	public String approvedelete(String id)throws Exception{
		adminManagerApproveService.approvedelete(id);
		return "redirect:/approveList.ado";
	}

	
	@RequestMapping(value = "/approval.ado" ,method=RequestMethod.GET)
	   public String View(@ModelAttribute AdminManagerApproveVO vo)throws Exception{
		adminManagerApproveService.approveupdate(vo);  
	   return "redirect:/approveList.ado";
	   }
	
	
	 @RequestMapping(value="/approve.ado", method=RequestMethod.GET)
	   public String mainView() {
	      return  "redirect:/approveList.ado";
	}
	 
	 @RequestMapping(value = "/approveList.ado")
	  public ModelAndView list()throws Exception{ 
	  List<AdminManagerApproveVO> list = adminManagerApproveService.approveList(); 
	  ModelAndView mav= new ModelAndView();
	  mav.setViewName("approveList");
	  Map<String,Object> map = new HashMap<>();
	  map.put("list",list);
	  mav.addObject("map",map);
	  return mav;
	 }
	 
}
