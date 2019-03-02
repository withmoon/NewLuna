package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
import com.study.luna.admin.model.vo.AdminQnABoardVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.member.service.Impl.MemberServiceImpl;
import com.study.luna.user.room.service.RoomService;

@Controller
public class UserInformController {
	@Autowired
	AdminNoticeBoardService noticeBoardService;
	@Autowired
	AdminQnABoardService qnaBoardService;
	@Autowired
	MgService qboardService;
	@Autowired
	RoomService roomser;
	
	//공지사항 목록
	@RequestMapping(value="/inform.udo", method=RequestMethod.GET)
	public ModelAndView informView(@RequestParam(defaultValue="1") int curPage,
									ModelAndView mav, HttpSession session) {
		//페이징 처리
		int count = noticeBoardService.countNotice(mav);
		

		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminNoticeBoardVO> noticeList = noticeBoardService.noticeAll(start, end, session);
		
		List<String> sido=roomser.getSido();
		
		mav.addObject("sido",sido);
		mav.addObject("noticeList", noticeList);
		mav.addObject("boardPager", boardPager); //페이징
		
		return mav;
	}
	
	//자주묻는 질문 목록
	@RequestMapping(value="/informChange.udo", method=RequestMethod.GET)
	public @ResponseBody List<?> informQnNAView(@RequestParam(value="informQ", required=false,defaultValue="")String informQ,
												@RequestParam(value="qnaPage", required=false,defaultValue="")String qnaPage,
												@RequestParam(defaultValue="1") int curPage, ModelAndView mav, HttpSession session) {
		//페이징 처리
		int count = qnaBoardService.countQnA(mav);
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		//목록
		List<AdminQnABoardVO> qnaList = new ArrayList<AdminQnABoardVO>();
		List<AdminNoticeBoardVO> noticeList = new ArrayList<AdminNoticeBoardVO>();
		if(informQ.equals("informQnA")) {
			qnaList = qnaBoardService.qnaAll(start, end, session);
			informQ.equals("");
			mav.addObject("qnaList", qnaList);
			mav.addObject("boardPager", boardPager);
			return qnaList;
		} else {
			noticeList = noticeBoardService.noticeAll(start, end, session);
			mav.addObject("noticeList", noticeList);
			mav.addObject("boardPager", boardPager);
			return noticeList;
		}
	}
	
	//고객의 소리 insert
	@RequestMapping(value="/informUser.udo", method=RequestMethod.POST)
	public @ResponseBody void informUser(@RequestParam(value="branchName") String branchName,
										@RequestParam(value="title") String title, @RequestParam(value="content") String content,
										QBoardVO qboardVO, HttpSession session) {
		
		MemberCommand memcom= (MemberCommand) session.getAttribute("member");

		qboardVO.setId(memcom.getId());
		//qboardVO.setEmail(memcom.getEmail());
		//qboardVO.setEmail(email);
		qboardVO.setBranchName(branchName);
		qboardVO.setTitle(title);
		qboardVO.setContent(content);
		
		qboardService.create(qboardVO);
	}
}
