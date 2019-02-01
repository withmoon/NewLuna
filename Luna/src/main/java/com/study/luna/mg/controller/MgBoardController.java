package com.study.luna.mg.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;

@Controller
public class MgBoardController {

	@Autowired
	private MgService MgService;

	/* 문의게시판 */
	@RequestMapping(value = "/board.mdo", method = RequestMethod.GET)
	public ModelAndView mgBoardView(QBoardVO vo) throws Exception {
		List<QBoardVO> list = MgService.QboardList(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board");
		mv.addObject("list", list);

		System.out.println("list" + list.toString());
		System.out.println("mv" + mv.toString());
		return mv;
	}

	/* 게시글 상세보기 */
	@RequestMapping(value = "/boardview.mdo", method = RequestMethod.GET)
	public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/boardview");
		mv.addObject("view", MgService.QbaordRead(title));
		return mv;
	}
	/*
	 * @RequestMapping(value = "/boardupdate.mdo", method = RequestMethod.GET)
	 * public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession
	 * session)throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("body/boardupdate");
	 * mv.addObject("view",MgService.QbaordRead(title)); return mv; }
	 */
	@RequestMapping(value = "/boardinsert.mdo", method = RequestMethod.GET)
	public String mgboardinsertView() {
		return "/body/boardinsert";
	}

}
