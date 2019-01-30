package com.study.luna.mg.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.mg.service.mgServiceImpl;
import com.sun.xml.internal.ws.developer.UsesJAXBContext;

@Controller
public class MgBoardController {
	
	@Autowired
	private MgService MgService;
	
	@RequestMapping(value="/board.mdo", method=RequestMethod.GET)
	public ModelAndView mgBoardView(QBoardVO vo) throws Exception {
		List<QBoardVO> list = MgService.QboardList(vo); 
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		mv.addObject("list",list);
		
		System.out.println("list"+list.toString());
		System.out.println("mv"+mv.toString());
		return mv;
	} 
	
	@RequestMapping(value = "/boardinsert.mdo", method = RequestMethod.GET)
	public String mgboardinsertView() {
		return "/body/boardinsert";
	}
}
