package com.study.luna.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.AlamDTO;
@Controller
public class UserGetUserQnAllController {
	@Autowired
	MgService mgser;
	
	@RequestMapping(value="/qnalist.udo",method=RequestMethod.GET) 
	public @ResponseBody JSONObject getUserQnAll(HttpSession session,MemberCommand memcom,
																		@RequestParam(value="curpage",defaultValue = "1") int curPage) {
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		int count =mgser.getUserQnCount(memcom.getId());
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		//알림 정보 가져오기
		List<QBoardVO> qnalist=mgser.getUserQnAll(start,end,memcom.getId());
		
		JSONObject obj = new JSONObject();
		obj.put("alist", qnalist);
		obj.put("apager", pager);
		return obj;
	}
}
