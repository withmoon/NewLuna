package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.service.MgService;

@Controller
public class MgBoardController {

	@Autowired
	private MgService MgService;

	/* 문의게시판 */
	@RequestMapping(value = "/mgBoard.mdo")
	public ModelAndView mgBoardView(@RequestParam(defaultValue="title")String searchOption,
						@RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage) throws Exception {
		//레코드계산
		int count = MgService.countArticle(searchOption,keyword);
		
		//페이지 나누기처리
		BoardPager boardPager= new BoardPager(count,curPage);
		int start = boardPager.getPageBegin(); 
		int end = boardPager.getPageEnd(); 
		
		List<QBoardVO> list = MgService.QboardList(start,end,searchOption,keyword);

		Map<String, Object> map = new HashMap<String,Object>();
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
	/* 문의게시판 */ //일반처리
/*	@RequestMapping(value = "/mgBoard.mdo", method = RequestMethod.GET)
	public ModelAndView mgBoardView(QBoardVO vo) throws Exception {
		List<QBoardVO> list = MgService.QboardList(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("mgBoard");
		mv.addObject("list", list);

		System.out.println("list" + list.toString());
		System.out.println("mv" + mv.toString());
		return mv;
	}
*/
	/* 게시글 상세보기 */
	@RequestMapping(value = "/mgBoardview.mdo")
	public ModelAndView mgboardinsertView(@RequestParam int num, @RequestParam int curPage,
				@RequestParam String searchOption,@RequestParam String keyword,HttpSession session ) throws Exception {
		
		
//		조회수 대비 MgService.increaseViewcnt(bno, session);*/
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
		mv.addObject("view", MgService.QbaordRead(num));
		return mv;
	}
	
	/* 상세보기 화면처리
	@RequestMapping(value = "/mgBoardview.mdo")
	public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession session) throws Exception {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/board/mgBoardview");
		mv.addObject("view", MgService.QbaordRead(title));
		return mv;
	}
*/
	/*수정하기*///수정할필요없어 주석처리
	 /* @RequestMapping(value = "/boardupdate.mdo", method = RequestMethod.GET)
	 * public ModelAndView mgboardinsertView(@RequestParam String title, HttpSession
	 * session)throws Exception {
	 * 
	 * ModelAndView mv = new ModelAndView(); mv.setViewName("body/boardupdate");
	 * mv.addObject("view",MgService.QbaordRead(title)); return mv; }
	 */
	
	//화면만 연결해둠 답글로 화면수정해야함
	@RequestMapping(value = "/mgBoardinsert.mdo", method = RequestMethod.GET)
	public String mgboardinsertView() {
		return "/body/mgBoardinsert";
	}

}
