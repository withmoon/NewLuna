package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
import com.study.luna.admin.model.vo.AdminQnABoardVO;
import com.study.luna.mg.model.BoardPager;

@Controller
public class UserInformController {
	@Autowired
	AdminNoticeBoardService noticeBoardService;
	@Autowired
	AdminQnABoardService qnaBoardService;
	
	//공지사항 목록
	@RequestMapping(value="/inform.udo", method=RequestMethod.GET)
	public ModelAndView informView(@RequestParam(value="cmd",required=false,defaultValue="") String cmd,
									@RequestParam(defaultValue="1") int curPage,
									ModelAndView mav, HttpSession session) {
		//페이징 처리
		int count = noticeBoardService.countNotice(mav);
		
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminNoticeBoardVO> noticeList = noticeBoardService.noticeAll(start, end, session);
		
		if(cmd.equals("quest")) {
			
		}
		
		mav.addObject("cmd",cmd);
		mav.addObject("noticeList", noticeList);
		mav.addObject("boardPager", boardPager); //페이징
		
		return mav;
	}
	
	//자주묻는 질문 목록
	@RequestMapping(value="/informChange.udo", method=RequestMethod.GET)
	public @ResponseBody List<AdminQnABoardVO> informQnNAView(@RequestParam(value="cmd",required=false,defaultValue="") String cmd,
									@RequestParam(value="informQ", required=false,defaultValue="")String informQ,
									@RequestParam(defaultValue="1") int curPage,
									ModelAndView mav, HttpSession session) {
		//페이징 처리
		int count = qnaBoardService.countQnA(mav);
		
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminQnABoardVO> qnaList = new ArrayList<AdminQnABoardVO>();
		List<AdminNoticeBoardVO> noticeList = new ArrayList<AdminNoticeBoardVO>();
		if(cmd.equals("quest")) {
			
		}
		
		if(informQ.equals("informQnA")) {
			qnaList = qnaBoardService.qnaAll(start, end, session);
		} else {
			noticeList = noticeBoardService.noticeAll(start, end, session);
		}
		
		mav.addObject("cmd",cmd);
		mav.addObject("qnaList", qnaList);
		mav.addObject("boardPager", boardPager); //페이징
		
		return qnaList;
	}
}
