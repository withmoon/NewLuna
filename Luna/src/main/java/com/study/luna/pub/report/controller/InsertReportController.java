package com.study.luna.pub.report.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.service.ReportService;

@Controller
public class InsertReportController {
	
	private String filePath="C:\\myProject\\myMainProject\\NewLuna\\Luna\\src\\main\\webapp\\resources\\report\\";
	
	@Autowired
	ReportService rpser;
	
	@RequestMapping(value="/insertReport.do", method=RequestMethod.POST)
	public String insertreport(ReportDTO rpd,MultipartHttpServletRequest mpreq,HttpServletRequest req,HttpSession session) throws IllegalStateException, IOException {
		//MemberCommand memcom=(MemberCommand) session.getAttribute("id");
		//session.setAttribute("id", memcom.getId());
			Integer seq=2;
			filePath+=seq+"\\";
			File dir = new File(filePath); 
			if (!dir.isDirectory()) {
				System.out.println("디렉토리생성");
				dir.mkdirs();
			}
			MultipartFile mf = mpreq.getFile("ffname");
			System.out.println("파일 추출 "+mf.getOriginalFilename());
			// 저장되는 파일 이름
			String reportxsls=mf.getOriginalFilename();
			String savePath = filePath + reportxsls; // 저장 될 파일 경로
			mf.transferTo(new File(savePath)); // 파일 저장
			rpd.setOrginfname(savePath);
			rpd.setFname(reportxsls);
			rpd.setId("brman2");
			rpd.setTitle((String)req.getParameter("title"));
			rpd.setContent((String)req.getParameter("content"));
			rpser.insertReport(rpd);
			
			return "redirect:/mgreport.mdo";
	}

}
