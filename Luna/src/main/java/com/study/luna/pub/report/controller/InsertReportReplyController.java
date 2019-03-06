package com.study.luna.pub.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.pub.command.ReportReplyDTO;
import com.study.luna.pub.report.service.ReportService;

@Controller
public class InsertReportReplyController {
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/insertReportReply.do", method=RequestMethod.POST)
	public @ResponseBody void insertReportReply(ReportReplyDTO rrd,@RequestParam("seq") int reportseq,@RequestParam("reply") String reply,@RequestParam(value="type",required=false,defaultValue="") String type) {
		//session의 브랜치 네임 가져오기
		if(type.equals("admin")) {
			rrd.setBranchname("본점");
		}else {
			rrd.setBranchname("토즈 강남점");
		}
		
		rrd.setReply(reply);
		rrd.setReportseq(reportseq);
		rpser.insertReportReply(rrd);
	}
}
