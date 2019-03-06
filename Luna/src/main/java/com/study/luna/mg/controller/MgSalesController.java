package com.study.luna.mg.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.QBoardVO;
import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.service.MgPCService;
import com.study.luna.mg.util.listExcelDownload;

@Controller
public class MgSalesController {
	//현황

	@Autowired
	private MgPCService MgPCService; 

	//회원관리
	@RequestMapping(value = "/mgSales.mdo")
	public ModelAndView mgSalesView(@RequestParam(defaultValue = "name") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {

		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("카카오 로그인 실패");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
		// 레코드계산      
		int count = MgPCService.countArticle(keyword);

		System.out.println("키워드 :" + keyword.toString());
		System.out.println("카운트 :" + count);
		
		int page_scale = 20;
		int block_sclae = 3;
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<SalesVO> list = MgPCService.SalesList(start, end, keyword,searchOption);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		mv.setViewName("body/presentCondition/mgSales");
		mv.addObject("map", map);

		System.out.println("mgsales 화면");
		return mv;
	}
    //엑셀다운로드
	@RequestMapping(value = "/excelDownload.mdo")
	public View excelDownload(HttpServletRequest request, HttpServletResponse response, Model model, SalesVO vo)
			throws Exception {

		//List<SalesVO> list = MgPCService.mgReserveList(vo);

		//model.addAttribute("list", list);

		return new listExcelDownload();
	}

	// 예약현황
	@RequestMapping(value = "/mgReserve.mdo")
	public ModelAndView mgReserveView(@RequestParam(defaultValue = "roomnum") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("카카오 로그인 실패");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
		String branchName = (String)session.getAttribute("branchName");
		int count = MgPCService.ReserveCount(searchOption, keyword,branchName);
		

		int page_scale = 10;
		int block_sclae = 5;
		// 페이지 나누기처리 
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		
		List<SalesVO> list = MgPCService.mgReserveList(start, end, searchOption, keyword,branchName);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);
		
		mv.addObject("map", map);
		mv.setViewName("body/presentCondition/mgReserve");

		return mv;
	}
	
	//환불하기
	@RequestMapping(value = "/mgRefund.mdo")
	public ModelAndView Reserve(@RequestParam(defaultValue = "roomnum") String searchOption,
			@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage,
			HttpSession session)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		if(session.getAttribute("branchName")==null){
			 System.out.println("카카오 로그인 실패");
			 mv.setViewName("loginX.mdo");
	         return mv;
		}
		
	String branchName = (String)session.getAttribute("branchName");
	int count = MgPCService.RefundCount(searchOption, keyword,branchName);
	
	int page_scale = 20;
	int block_sclae = 4;
	// 페이지 나누기처리  
	BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
	int start = boardPager.getPageBegin();
	int end = boardPager.getPageEnd();
	Date nowdate = new Date();
	System.out.println(nowdate);
	
	List<SalesVO> list = MgPCService.mgRefund(start, end, searchOption, keyword,branchName);

	Map<String, Object> map = new HashMap<String, Object>();
	map.put("list", list);
	map.put("count", count);
	map.put("searchOption", searchOption);
	map.put("keyword", keyword);
	map.put("boardPager", boardPager);
	map.put("nowdate",nowdate);
	 
	mv.addObject("map", map);
	//MgPCService.mgReserve(vo);
	mv.setViewName("body/presentCondition/mgRefund");

	return mv;
	}
	
	@RequestMapping(value="Refund.mdo",method=RequestMethod.POST)
	public void Refund() {
		System.out.println("환불조치");
		//MgPCService.Refund();
	}
	

/*	// 방문현황
	@RequestMapping(value = "/mgVisit.mdo", method = RequestMethod.GET)
	public String mgVisitView() {
		return "body/presentCondition/mgVisit";
	}
*/
	
}
