package com.study.luna.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.comment.service.NoticeReplyService;
import com.study.luna.user.comment.vo.NoticeReplyVO;

@Controller
public class UserViewNoticeController {
	@Autowired
	AdminNoticeBoardService noticeBoardService;
	@Autowired
	NoticeReplyService noticeReplyService;
	
	//공지사항_질문사항 상세보기
	@RequestMapping(value="/viewNotice.udo", method=RequestMethod.GET)
	public ModelAndView viewNoticeView(int num, HttpSession session,MemberCommand memcom,HttpServletRequest request) throws Exception {
		
		//여서부터
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
			if(flashMap!=null) {
				memcom.setId(flashMap.get("id").toString());
				session.setAttribute("member", memcom);
			}else {
				memcom=(MemberCommand)session.getAttribute("member");
			}
						
			session.setAttribute("member", memcom);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("viewNotice");
		mav.addObject("nbv", noticeBoardService.read(num));
		return mav;
	}
	
	//댓글 목록
	@RequestMapping(value="/nReplyList.udo", method=RequestMethod.GET)
	public @ResponseBody List<NoticeReplyVO> nReplyListView(@RequestParam(value="nreList") String nreList, @RequestParam(value="num") int num,
															ModelAndView mav, NoticeReplyVO nReplyVO,  HttpSession session) {
		nReplyVO.setNum(num);
		
		List<NoticeReplyVO> nReplyList = new ArrayList<NoticeReplyVO>();
		if(nreList.equals("nreL")) {
			nReplyList = noticeReplyService.nReplyList(num, session);
		}
		mav.addObject("nReplyList", nReplyList);
		return nReplyList;
	}
	
	//댓글 입력
	@RequestMapping(value="/nReplyInsert.udo", method=RequestMethod.POST)
	public @ResponseBody void nReplyInsert(@RequestParam(value="content") String content,@RequestParam(value="bnum") int num,NoticeReplyVO nReplyVO, HttpSession session) {
		MemberCommand memcom= (MemberCommand) session.getAttribute("member");
		
		nReplyVO.setReplyer(memcom.getId());
		nReplyVO.setReplytext(content);
		nReplyVO.setNum(num);
		noticeReplyService.create(nReplyVO);
	}
}
