package com.study.luna.admin.controller;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;


@Controller
public class AdminInquireController {

	@Autowired
	MgService service;

	@Autowired
	private JavaMailSender mailSender;
	  
	@RequestMapping(value = "/inquire.ado")
	public String view() {
		return "inquire";
	}
	
	//문의계시판
	@RequestMapping(value = "/inquireList.ado", method=RequestMethod.GET)
	public @ResponseBody JSONObject  inquireList(@RequestParam(defaultValue="1") int curPage,
									QBoardVO qboardVO, HttpSession session,
									@RequestParam(value="searchOption",defaultValue = "title") String searchOption,
									@RequestParam(value="keyword",defaultValue = "") String keyword) {
		//페이징 처리
    	int count = service.countInqure(searchOption, keyword);
    			
    	int page_scale = 10; // 페이지당 게시물 수
    	int block_sclae = 5; // 화면당 페이지 수
    	// 페이지 나누기처리 
    	BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

    	int start = boardPager.getPageBegin();
    	int end = boardPager.getPageEnd();
    	
    	
		List<QBoardVO> inquireList = service.inquireList(start, end, searchOption, keyword, session);
		
		JSONObject obj = new JSONObject();

    	obj.put("inquireList", inquireList);
    	obj.put("inquirePage", boardPager);
    	return obj;
	}

	@RequestMapping(value = "/inquireinsert.ado", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, @ModelAttribute QBoardVO qboardVO) throws Exception {
		service.inquireinsert(qboardVO);
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

	

	@RequestMapping(value = "/inquirewrite.ado")
	public ModelAndView views(@RequestParam Integer seq) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("inquirewrite");
		mav.addObject("seq", service.inquireread(seq));
		return mav;
	}
	
	@RequestMapping(value = "/inquiredelete.ado" ,method=RequestMethod.GET)
    public @ResponseBody void delete(@RequestParam("seq") int seq) throws Exception {
    	service.inquiredelete(seq);
    }   
}
