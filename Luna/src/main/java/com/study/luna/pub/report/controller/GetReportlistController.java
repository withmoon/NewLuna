package com.study.luna.pub.report.controller;

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
import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.service.ReportService;

@Controller
public class GetReportlistController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/getReportlist.do", method=RequestMethod.POST)
	public @ResponseBody JSONObject getReportlist(ReportDTO rpd,HttpSession session,@RequestParam("curPage") int curPage,@RequestParam(value="searchOption",required=false,defaultValue="title") String searchOption,@RequestParam(value="keyword",required=false,defaultValue="") String keyword){
		//MemberCommand memcom=(MemberCommand)session.getAttribute("member");
		//session.setAttribute("member", memcom);
		rpd.setId("brman2");
		Integer count = rpser.getReportCount(rpd);
		
		int page_scale = 3;
		int block_sclae = 3;
		// 페이지 나누기처리 
		BoardPager pager = new BoardPager(count, curPage,page_scale,block_sclae);

		int start = pager.getPageBegin();
		int end = pager.getPageEnd();

		List<ReportDTO> reportlist=rpser.getReportlist(start, end, "brman2",searchOption,keyword);
		
		JSONObject obj = new JSONObject();
		obj.put("count", count);
		obj.put("list", reportlist);
		obj.put("pager", pager);
		return obj;
	}
}
