package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.BAD_INV_ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.BoardPager2;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;

@Controller
public class MgBoardController {

	@Autowired
	private MgService MgService;

	@Autowired
	private JavaMailSender mailSender;

	/* 문의게시판 */
	@RequestMapping(value = "/mgBoard.mdo")
	public ModelAndView mgBoardView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		
		
		String id = (String)session.getAttribute("id");
		System.out.println(id + "지점 문의게시글");
		// 레코드계산 
		int count = MgService.countArticle(searchOption, keyword,id);
		System.out.println(count+"개");

		
//		int page_scale = 3;
		// 페이지 나누기처리
//		BoardPager2 boardPager = new BoardPager2(count, curPage,page_scale);
		BoardPager2 boardPager = null;
		int page = 3; 
		boardPager.setPAGE_SCALE(4);
		System.out.println(boardPager.getPAGE_SCALE());
//		boardPager.setPAGE_SCALE(page);
		boardPager = new BoardPager2(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<QBoardVO> list = MgService.QboardList(start, end, searchOption, keyword,id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		ModelAndView mv = new ModelAndView();
		mv.addObject("map", map);
		mv.setViewName("mgBoard");

		System.out.println("list" + list.toString());
		System.out.println("mv" + mv.toString());
		return mv;
	}

	/*
	 * 문의 게시판 //일반처리 /* @RequestMapping(value = "/mgBoard.mdo", method =
	 * RequestMethod.GET) public ModelAndView mgBoardView(QBoardVO vo) throws
	 * Exception { List<QBoardVO> list = MgService.QboardList(vo); ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("mgBoard"); mv.addObject("list", list);
	 * 
	 * System.out.println("list" + list.toString()); System.out.println("mv" +
	 * mv.toString()); return mv; }
	 */
	/* 게시글 상세보기 */
	@RequestMapping(value = "/mgBoardview.mdo")
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage,QBoardVO vo,
			@RequestParam String searchOption, @RequestParam String keyword, HttpSession session) throws Exception {

//		조회수 대비 MgService.increaseViewcnt(bno, session);*/
		vo.setId((String) session.getAttribute("id"));
		vo.setNum(num);
		System.out.println("상세보기 id"+vo.getId());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
		mv.addObject("view", MgService.QbaordRead(vo));
		return mv;
	}

	/*
	 * 상세보기 화면처리
	 * 
	 * @RequestMapping(value = "/mgBoardview.mdo") public ModelAndView
	 * mgboardinsertView(@RequestParam String title, HttpSession session) throws
	 * Exception {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * mv.setViewName("body/board/mgBoardview"); mv.addObject("view",
	 * MgService.QbaordRead(title)); return mv; }
	 */
	/* 수정하기 */// 수정할 필요없어 주석처리
	/*
	 * @RequestMapping(value = "/boardupdate.mdo", method = RequestMethod.GET)
	 * public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession
	 * session)throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("body/boardupdate");
	 * mv.addObject("view",MgService.QbaordRead(title)); return mv; }
	 */

	// 화면만 연결해둠 답글로 화면수정해야함
	@RequestMapping(value = "/mgBoardinsert.mdo", method = RequestMethod.GET)
	public String mgboardinsertView() {
		return "/body/mgBoardinsert";
	}

	// mailForm
	@RequestMapping(value = "/mailForm.mdo")
	public String mailForm() {

		return "/body/mailForm";
	}

	// mailSending 코드
	@RequestMapping(value = "/mailSending.mdo")
	public String mailSending(HttpServletRequest request) {

//		String setfrom = "gur792816@gmail.com"; //보내는이?
		String setfrom = "manager@gmail.com";
		String tomail = request.getParameter("tomail"); // 받는 사람 이메일
		String title = request.getParameter("title"); // 제목
		String content = request.getParameter("content"); // 내용
		MimeMessage message = mailSender.createMimeMessage(); 
		try {

			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 보내는사람 생략하거나 하면 정상작동을 안함
			messageHelper.setTo(tomail); // 받는사람 이메일
			messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
			messageHelper.setText(content); // 메일 내용

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}

		return "/body/mailForm";
	}

}
