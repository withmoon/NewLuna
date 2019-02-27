package com.study.luna.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.admin.board.service.AdminInquireBoardService;
import com.study.luna.admin.model.vo.AdminInquireBoardVO;


@Controller
public class AdminInquireController {

	@Inject
	AdminInquireBoardService service;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/inquireinsert.ado", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, @ModelAttribute AdminInquireBoardVO vo) throws Exception {
		service.inquireinsert(vo);
		String setfrom = "moon@gmail.com";
		String tomail = request.getParameter("tomail"); // �޴»�� �̸���
		String reply = request.getParameter("reply"); // ����
		String title = request.getParameter("title"); // ����
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // �����»�� �����ϰų� �ϸ� �����۵��� ����
			messageHelper.setTo(tomail); // �޴»�� �̸���
			messageHelper.setSubject(title); // ����
			messageHelper.setText(reply); // ���� ����
			
			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "redirect:/inquireList.ado";
	}

	@RequestMapping(value = "/inquire.ado")
	public String view() {
		return "redirect:/inquireList.ado";
	}

	@RequestMapping(value = "/inquirewrite.ado")
	public ModelAndView views(@RequestParam Integer seq) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inquirewrite");
		mav.addObject("seq", service.inquireread(seq));
		return mav;
	}

	@RequestMapping(value = "/inquireList.ado")
	public ModelAndView list() throws Exception {
		List<AdminInquireBoardVO> list = service.inquireList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inquireList");
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		mav.addObject("map", map);
		return mav;
	}
	
	@RequestMapping(value = "/inquiredelete.ado" ,method=RequestMethod.GET)
    public String delete(@RequestParam int seq) throws Exception {
    	service.inquiredelete(seq);
       return "redirect:/inquireList.ado";
    }   
}
