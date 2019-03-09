package com.study.luna.admin.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminQnABoardVO;
import com.study.luna.pub.command.MemberCommand;

@Controller
public class AdminQnABoardWriteController {

	@Inject
	AdminQnABoardService adminQnABoardService;

	@RequestMapping(value = "/qnaupdate.ado", method = RequestMethod.POST)
	public String View(@ModelAttribute AdminQnABoardVO vo) throws Exception {
		adminQnABoardService.update(vo);
		return "redirect:/board.ado";
	}

	@RequestMapping(value = "/qnadelete.ado")
	public String deleteView(@RequestParam int num, HttpSession session, MemberCommand memcom) throws Exception {
		memcom = (MemberCommand) session.getAttribute("member");

		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			adminQnABoardService.delete(num);
			return "redirect:/board.ado";
		}
		return "cannotAccess";

	}

	@RequestMapping(value = "/write.ado", method = RequestMethod.GET)
	public ModelAndView mainView(AdminQnABoardVO aqb, HttpSession session, MemberCommand memcom) {
		memcom = (MemberCommand) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		System.out.println(memcom.getPosition()+"===자주묻는 질문====-----------------><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			session.setAttribute("member", memcom);

			mav.addObject("qncontent", aqb);
			mav.setViewName("write");
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;

	}

	@RequestMapping(value = "/qnaview.ado", method = RequestMethod.GET)
	public ModelAndView view(@RequestParam("num") int num, HttpSession session, MemberCommand memcom) throws Exception {
		memcom = (MemberCommand) session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			mav.setViewName("qnaview");
			mav.addObject("num", adminQnABoardService.read(num));
			return mav;
		}
		mav.setViewName("cannotAccess");
		return mav;
		
		
	}

	/*
	 * @RequestMapping(value = "/boardList.ado") public ModelAndView list()throws
	 * Exception{ List<AdminQnABoardVO> list = adminQnABoardService.listAll();
	 * ModelAndView mav= new ModelAndView(); mav.setViewName("boardList");
	 * Map<String,Object> map = new HashMap<>(); map.put("list",list);
	 * mav.addObject("map",map); return mav; }
	 */

	@RequestMapping(value = "/insert.ado")
	public String insert(@ModelAttribute AdminQnABoardVO adminQnABoardVO, HttpSession session, MemberCommand memcom) throws Exception {
		memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
			adminQnABoardService.insert(adminQnABoardVO);
			return "redirect:/board.ado";
		}
		return "cannotAccess";
	}

}