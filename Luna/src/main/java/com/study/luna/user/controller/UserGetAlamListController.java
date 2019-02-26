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
import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.alamandqa.service.AlamServiceImpl;
import com.study.luna.user.dto.AlamDTO;
@Controller
public class UserGetAlamListController {
	
	@Autowired
	AlamServiceImpl alser;
	
	@RequestMapping(value="/alamlist.udo",method=RequestMethod.GET) 
	public @ResponseBody JSONObject changekeeproom(HttpSession session,MemberCommand memcom,
																		@RequestParam(value="curpage",defaultValue = "1") int curPage) {
		memcom=(MemberCommand)session.getAttribute("member");
		session.setAttribute("member", memcom);
		
		int count = alser.getAlamCount(memcom.getId());
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager keepPager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = keepPager.getPageBegin();
		int end = keepPager.getPageEnd();

		//알림 정보 가져오기
		List<AlamDTO> alamlist=alser.getAlamlist(start,end,memcom.getId());
		
		JSONObject obj = new JSONObject();
		obj.put("alist", alamlist);
		obj.put("apager", keepPager);
		return obj;
	}
}
