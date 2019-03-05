package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.omg.CORBA.BAD_INV_ORDER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.study.luna.admin.board.service.AdminNoticeBoardService;
import com.study.luna.admin.model.vo.AdminNoticeBoardVO;
import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.pub.command.MemberCommand;

@Controller
public class MgBoardController {
	// 게시판관리

	@Autowired
	private MgService MgService;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	AdminNoticeBoardService noticeBoardService;

	/* 문의게시판 */
	@RequestMapping(value = "/mgBoard.mdo")
	public ModelAndView mgBoardView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("카카오 로그인 실패");
			mv.setViewName("/body/loginX");
			return mv;
		}

		String branchName = (String) session.getAttribute("branchName");
		System.out.println(branchName + "지점 문의게시글");
		// 레코드계산
		int count = MgService.countArticle(searchOption, keyword, branchName);
		System.out.println(count + "개");

		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<QBoardVO> list = MgService.QboardList(start, end, searchOption, keyword, branchName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.addObject("map", map);
		mv.setViewName("body/board/mgBoard");

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
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage, QBoardVO vo,
			@RequestParam String searchOption, @RequestParam String keyword, HttpSession session) throws Exception {

//		조회수 대비 MgService.increaseViewcnt(bno, session);*/
		vo.setBranchName((String) session.getAttribute("branchName"));
		vo.setSeq(num);
		System.out.println("상세보기 id" + vo.getBranchName());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
		mv.addObject("view", MgService.QbaordRead(vo));
		return mv;
	}

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
	public String mailForm(QBoardVO vo) throws Exception {
		return "/body/mailForm";
	}

	@RequestMapping(value = "/mailView.mdo")
	public String mailView() {
		return "/body/mailView";
	}

	// mailSending 코드
	@RequestMapping(value = "/mailSending.mdo", method = RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, QBoardVO vo, HttpSession session) throws Exception {

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
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setEmail(request.getParameter("email"));
		vo.setEmailtitle(title);
		vo.setEmailcontent(content);
		vo.setBranchName((String) session.getAttribute("branchName"));

		MgService.mailstatus(vo);

		// 리턴시 스크립트 화면이동이 막혀 모든 기능을 수행후 슬립
		// 리턴 널을 하면 에러 발생 /임시조치로 기능정지 - 기능정지동안 스크립트에서 화면전환 수행으로 컨트롤러 종료
		Thread.sleep(20000);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/body/mailForm");
		return mv;

	}
	
	@RequestMapping(value = "/mgGong.mdo")
	public ModelAndView informView(/*@RequestParam(defaultValue = "title") String searchOption,@RequestParam(defaultValue = "") String keyword,*/
			@RequestParam(defaultValue = "1") int curPage,AdminNoticeBoardVO noticeboardVO, HttpSession session) {
		//페이징 처리
		int count = noticeBoardService.countNotice(noticeboardVO.getTitle());
		//int count = noticeBoardService.countNotice(mav);

		int page_scale = 10; // 페이지당 게시물 수
		int block_sclae = 5; // 화면당 페이지 수
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		//목록
		List<AdminNoticeBoardVO> noticeList = noticeBoardService.noticeAll(start, end, session);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("count", count);
		map.put("boardPager", boardPager);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",noticeList);
		mv.addObject("map",map);
		mv.setViewName("/body/board/mgNoticeBoard");
		return mv;
	}
	
	@RequestMapping(value = "/mgEvenet.mdo")
	public String eventView(MemberCommand memcom, HttpSession session, HttpServletRequest request) {
		Map<String, ?> flashMap=RequestContextUtils.getInputFlashMap(request);
		if(flashMap!=null) {
			memcom.setId(flashMap.get("id").toString());
			session.setAttribute("member", memcom);
		}else {
			memcom=(MemberCommand)session.getAttribute("member");
		}
		
		return "/body/board/mgEvent";
	}
	
	@RequestMapping(value = "/Event.mdo")
	public String event() {
		return "/body/mailView";
	}

}
