package com.study.luna.admin.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.admin.board.service.AdminQnABoardService;
import com.study.luna.admin.model.vo.AdminQnABoardVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.pub.command.MemberCommand;

@Controller
public class AdminQNABoardController {    
    @Inject
    AdminQnABoardService qnaBoardService;
    
    @RequestMapping(value = "/board.ado")
    public String list(HttpSession session, MemberCommand memcom){ 
    	memcom = (MemberCommand) session.getAttribute("member");
		if (memcom.getPosition().equals("총관리자") | memcom.getPosition().equals("관리자")) {
			memcom = (MemberCommand) session.getAttribute("member");
			session.setAttribute("member", memcom);
			
	    	return "board";
		}
		return "cannotAccess";

     }
    
    @RequestMapping(value = "/boardList.ado", method=RequestMethod.GET)
    public @ResponseBody JSONObject boardList(@RequestParam(defaultValue="1") int curPage,
									AdminQnABoardVO qnaBoardVO, HttpSession session){ 
    	//페이징 처리
    	int count = qnaBoardService.countQnA(qnaBoardVO.getSubject());
    			
    	int page_scale = 10;
    	int block_sclae = 5;
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    			
    	//목록
    	List<AdminQnABoardVO> qnaList = qnaBoardService.qnaAll(start, end, session);
    			
    	JSONObject obj = new JSONObject();

    	obj.put("qnaList", qnaList);
    	obj.put("qnaPage", boardPager);
    	return obj;
    }
}