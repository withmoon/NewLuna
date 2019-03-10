package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	// 寃뚯떆�뙋愿�由�

	@Autowired
	private MgService MgService;

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	AdminNoticeBoardService noticeBoardService;
   
	/* 臾몄쓽寃뚯떆�뙋 */
	@RequestMapping(value = "/mgBoard.mdo")
	public ModelAndView mgBoardView(@RequestParam(defaultValue = "title") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("branchName") == null) {
			System.out.println("移댁뭅�삤 濡쒓렇�씤 �떎�뙣");
			mv.setViewName("/body/loginX");
			return mv;
		}

		String branchName = (String) session.getAttribute("branchName");
		System.out.println(branchName + "吏��젏 臾몄쓽寃뚯떆湲�");
		
		// �젅肄붾뱶怨꾩궛
		int count = MgService.countArticle(searchOption, keyword, branchName);
		System.out.println(count + "媛�");

		int page_scale = 10;
		int block_sclae = 5;
		// �럹�씠吏� �굹�늻湲곗쿂由�
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
	 * 臾몄쓽 寃뚯떆�뙋 //�씪諛섏쿂由� /* @RequestMapping(value = "/mgBoard.mdo", method =
	 * RequestMethod.GET) public ModelAndView mgBoardView(QBoardVO vo) throws
	 * Exception { List<QBoardVO> list = MgService.QboardList(vo); ModelAndView mv =
	 * new ModelAndView(); mv.setViewName("mgBoard"); mv.addObject("list", list);
	 * 
	 * System.out.println("list" + list.toString()); System.out.println("mv" +
	 * mv.toString()); return mv; }
	 */
	/* 寃뚯떆湲� �긽�꽭蹂닿린 */
	@RequestMapping(value = "/mgBoardview.mdo")
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage, QBoardVO vo,
			@RequestParam String searchOption, @RequestParam String keyword, HttpSession session) throws Exception {
		//	議고쉶�닔 ��鍮� MgService.increaseViewcnt(bno, session);*/
		vo.setBranchName((String) session.getAttribute("branchName"));
		vo.setSeq(num);
		System.out.println("�긽�꽭蹂닿린 id" + vo.getBranchName());
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
		mv.addObject("view", MgService.QbaordRead(vo));
		return mv;
	}

	/* �닔�젙�븯湲� */// �닔�젙�븷 �븘�슂�뾾�뼱 二쇱꽍泥섎━
	/*
	 * @RequestMapping(value = "/boardupdate.mdo", method = RequestMethod.GET)
	 * public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession
	 * session)throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("body/boardupdate");
	 * mv.addObject("view",MgService.QbaordRead(title)); return mv; }
	 */

	// �솕硫대쭔 �뿰寃고빐�몺 �떟湲�濡� �솕硫댁닔�젙�빐�빞�븿
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

	// mailSending 肄붾뱶
	@RequestMapping(value = "/mailSending.mdo", method = RequestMethod.POST)
	public ModelAndView mailSending(HttpServletRequest request, QBoardVO vo, HttpSession session) throws Exception {

//		String setfrom = "gur792816@gmail.com"; //蹂대궡�뒗�씠?
		String setfrom = "manager@gmail.com";
		String tomail = request.getParameter("tomail"); // 諛쏅뒗 �궗�엺 �씠硫붿씪
		String title = "["+(String) session.getAttribute("branchName")+"]"+" 臾몄쓽�븯�떎 湲��뿉 �떟蹂��씠 �떖�졇�뒿�땲�떎" ;// �젣紐�
		String content = request.getParameter("content1")+"\r\n\r\n"+request.getParameter("content2"); // �궡�슜
		MimeMessage message = mailSender.createMimeMessage();
		try {

			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
			messageHelper.setTo(tomail); // 諛쏅뒗�궗�엺 �씠硫붿씪
			messageHelper.setSubject(title); // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
			messageHelper.setText(content); // 硫붿씪 �궡�슜

			mailSender.send(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		vo.setSeq(Integer.parseInt(request.getParameter("seq")));
		vo.setEmail(request.getParameter("email"));
		vo.setEmailtitle(title);
		vo.setEmailcontent(request.getParameter("content1"));
		vo.setReply(request.getParameter("content2"));
		vo.setBranchName((String) session.getAttribute("branchName"));

		MgService.mailstatus(vo);

		// 由ы꽩�떆 �뒪�겕由쏀듃 �솕硫댁씠�룞�씠 留됲� 紐⑤뱺 湲곕뒫�쓣 �닔�뻾�썑 �뒳由�
		// 由ы꽩 �꼸�쓣 �븯硫� �뿉�윭 諛쒖깮 /�엫�떆議곗튂濡� 湲곕뒫�젙吏� - 湲곕뒫�젙吏��룞�븞 �뒪�겕由쏀듃�뿉�꽌 �솕硫댁쟾�솚 �닔�뻾�쑝濡� 而⑦듃濡ㅻ윭 醫낅즺
		Thread.sleep(20000);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/body/mailForm");
		return mv;

	}
	
	@RequestMapping(value = "/mgGong.mdo")
	public ModelAndView informView(/*@RequestParam(defaultValue = "title") String searchOption,@RequestParam(defaultValue = "") String keyword,*/
			@RequestParam(defaultValue = "1") int curPage,AdminNoticeBoardVO noticeboardVO, HttpSession session) {
		//�럹�씠吏� 泥섎━
		int count = noticeBoardService.countNotice(noticeboardVO.getTitle());
		//int count = noticeBoardService.countNotice(mav);

		int page_scale = 10; // �럹�씠吏��떦 寃뚯떆臾� �닔
		int block_sclae = 5; // �솕硫대떦 �럹�씠吏� �닔
		// �럹�씠吏� �굹�늻湲곗쿂由� 
		BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);

		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		//紐⑸줉
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
