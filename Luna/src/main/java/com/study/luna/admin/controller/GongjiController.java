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

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;




@Controller
public class GongjiController {
    
	@Inject
	AdminNoticeBoardService adminNoticeBoardService;
	
	@RequestMapping(value="/gongji.ado", method=RequestMethod.GET)
    public String mainView() {
        return "redirect:/gongjiboardList.ado";
}
	
	@RequestMapping(value = "/gongjiupdate.ado" ,method=RequestMethod.POST)
	   public String View(@ModelAttribute AdminNoticeBoardVO vo)throws Exception{
		adminNoticeBoardService.noticeupdate(vo);  
	   return "redirect:/gongjiboardList.ado";
	   }
	
	
	 @RequestMapping(value = "/gongjiview.ado", method = RequestMethod.GET)
	   public ModelAndView view(@RequestParam int num) throws Exception {
	      ModelAndView mav = new ModelAndView();
	      mav.setViewName("gongjiview");
	      mav.addObject("num",adminNoticeBoardService.noticeread(num));
	      return mav;
	   }

	
	@RequestMapping(value="/gongjiwrite.ado", method=RequestMethod.GET)
    public String View() {
        return "gongjiwrite";
}
	
    
    @RequestMapping(value = "/noticeinsert.ado" ,method=RequestMethod.GET)
    public String insert(@ModelAttribute AdminNoticeBoardVO vo) throws Exception {
    	adminNoticeBoardService.noticeinsert(vo);
       return "redirect:/gongjiboardList.ado";
    }   
    
    @RequestMapping(value = "/gongjidelete.ado" ,method=RequestMethod.GET)
    public String delete(@RequestParam int num) throws Exception {
    	adminNoticeBoardService.noticedelete(num);
       return "redirect:/gongjiboardList.ado";
    }   
    
    
    @RequestMapping(value = "gongjiboardList.ado")
    public ModelAndView list()throws Exception{ 
    List<AdminNoticeBoardVO> list = adminNoticeBoardService.noticeList(); 
    ModelAndView mav= new ModelAndView();
    mav.setViewName("gongjiboardList");
    Map<String,Object> map = new HashMap<>();
    map.put("list",list);
    mav.addObject("map",map);
    return mav;
    }
    
    
 
}