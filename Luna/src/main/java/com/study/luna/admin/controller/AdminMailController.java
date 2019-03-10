package com.study.luna.admin.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.luna.admin.board.service.AdminManagerApproveService;
import com.study.luna.pub.member.service.MemberService;

@Controller
public class AdminMailController {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	MemberService memser;
	@Autowired
	AdminManagerApproveService adminManagerApproveService;
	
	String filePath="C:\\ProgramData\\DalBitmailImg\\";

	@RequestMapping(value = "/adminmail.ado")
	public String mainView() {
		return "adminmail";
	}

	@RequestMapping(value = "mailSending.ado")
	public String mailSending(HttpServletRequest request) {

		String setfrom = "kmh214900@gmail.com";// 보낼 관리자 gmail 계정
		String tomail = request.getParameter("tomail");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "mailsuccess";
	}

	@RequestMapping(value = "expulmember.ado")
	public @ResponseBody void expulmember(@RequestParam("id") String id, @RequestParam("email") String email,
			@RequestParam(value="content", required = false, defaultValue = "") String contents,
			@RequestParam(value = "title", required = false, defaultValue = "") String titles)
			throws MessagingException {
		
		String setfrom = "kmh214900@gmail.com";// 보낼 관리자 gmail 계정
		String tomail = email;
		String title = ((titles.equals("")&&!contents.equals(""))?"[달빛 스터디카페] 고객님께서 제명처리되셨습니다. 이유는 아래와 같습니다.":(contents.equals(""))?"[달빛 스터디카페] 회원님의 제명이 취소되었습니다.":titles);
		String content = contents;
		//제명 처리
		if(titles.equals("")) {
			memser.expulmember(id);
		}
		//제명 취소
		if(contents.equals("")) {
			memser.cancleExpulmember(id);
			content+=id+"님의 제명이 취소되었습니다.\r\n  http://localhost:8080/luna/main.do ";
		}

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

		messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
		messageHelper.setTo(tomail); // 받는사람 이메일
		messageHelper.setSubject(title); // 제목은 생략이 가능하다
		messageHelper.setText(content); // 메일 내용

		mailSender.send(message);
		
	}// 
	 
	
	@RequestMapping(value = "sendemail.ado", method = RequestMethod.POST)
	public String sendemail(MultipartHttpServletRequest mpreq,@RequestParam(value="id", required = false, defaultValue = "") String id, @RequestParam("email") String email,
			@RequestParam(value="content", required = false, defaultValue = "") String contents,
			@RequestParam(value = "title", required = false, defaultValue = "") String titles,
			@RequestParam(value = "jspname", required = false, defaultValue = "") String jspname,
			@RequestParam(value = "type", required = false, defaultValue = "") String type) throws Exception{
		System.out.println("폼전송 결과 " +id+ " " +email+" " +contents+" " +titles+" ============================================================================================================================>");
		InternetAddress setfrom=new InternetAddress("moonLightAdmin <saeah5806@gmail.com>");
		String content = contents;
		String title = titles;
		
		if(type.equals("approve")) {
			adminManagerApproveService.approveupdate(id);
		}
	
		String tomail []= email.split(";");
		for(String emails:tomail) {
		
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
		MultipartFile mf = mpreq.getFile("filename");
		if (!mf.getOriginalFilename().equals("")) {
			File dir = new File(filePath);
			if (dir.exists()) { // 파일존재여부확인
				if (dir.isDirectory()) { // 파일이 디렉토리인지 확인
					File[] files = dir.listFiles();
					for (int i = 0; i < files.length; i++) {
						files[i].delete();
					}
				}
			} else {
				if (!dir.isDirectory()) {
					System.out.println("디렉토리생성");
					dir.mkdirs();
				}
			}
		
		// 저장되는 파일 이름
		String reportxsls = mf.getOriginalFilename();

		String savePath = filePath + reportxsls; // 저장 될 파일 경로
		mf.transferTo(new File(savePath)); // 파일 저장
		
		FileSystemResource image=new FileSystemResource(savePath);
		messageHelper.addAttachment(reportxsls, image);
		}
		messageHelper.setFrom(setfrom); // 보내는사람 생략하면 안된다
		messageHelper.setTo(emails); // 받는사람 이메일
		messageHelper.setSubject(title); // 제목은 생략이 가능하다
		messageHelper.setText(content); // 메일 내용

		mailSender.send(message);
		}
		if(!jspname.equals("")) {
			return "redirect:/"+jspname+".ado";
		}
		return "redirect:/member.ado";
	}
	
	
}