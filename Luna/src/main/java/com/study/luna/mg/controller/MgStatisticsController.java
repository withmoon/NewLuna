package com.study.luna.mg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.model.StatisticsVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.mg.service.MgStatisticsService;
import com.study.luna.mg.util.listExcelDownload;

@Controller
public class MgStatisticsController {
	// 매출

		@Autowired
		public MgStatisticsService MgStatisticsService;
 
		// 일매출 
		@RequestMapping(value = "/mgSalesreserve.mdo")
		public ModelAndView mgSalesReserveView(@RequestParam(defaultValue ="") String date1,@RequestParam(defaultValue ="") String date2,
				@RequestParam(defaultValue = "1") int curPage,HttpSession session)
				throws Exception {
			if(date1==null || date1.equals("") ) {
				date1 = new SimpleDateFormat("yy/MM/dd").format(new Date());
			}
			if(date2==null || date2.equals("") ) {
				date2 = new SimpleDateFormat("yy/MM/dd").format(new Date());
			}
			session.setAttribute("date1", date1);
			session.setAttribute("date2", date2);
			

			String branchName = (String) session.getAttribute("branchName");
			System.out.println(branchName + "리스트");
			// 레코드계산
			int count = MgStatisticsService.count(date1, date2, branchName);
			System.out.println(count + "개");
			

			int page_scale = 10;
			int block_sclae = 5;
			// 페이지 나누기처리
			BoardPager boardPager = new BoardPager(count, curPage, page_scale, block_sclae);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd();

			List<StatisticsVO> list = MgStatisticsService.SalesReserveList(start, end, date1, date2);
			System.out.println(list); 
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("count", count);
			map.put("date1", date1);
			map.put("date2", date2);
			map.put("boardPager", boardPager);

			ModelAndView mv = new ModelAndView();
			mv.addObject("map", map);
			mv.setViewName("body/sales/mgSalesreserve");
			System.out.println(map);
			return mv;
		}
		
		  //엑셀다운로드
		@RequestMapping(value = "/excelDownload.mdo")
		public View excelDownload(@RequestParam(defaultValue = "1") int curPage,HttpSession session)
				throws Exception {
			String date1 = (String) session.getAttribute("date1");
			String date2 = (String) session.getAttribute("date2");
			String branchName = (String) session.getAttribute("branchName");
			
			
			// 레코드계산
			int count = MgStatisticsService.count(date1, date2, branchName);
			System.out.println(count + "개");
			
			//List<SalesVO> list = MgPCService.mgReserveList(vo);
			List<StatisticsVO> list = MgStatisticsService.excelList(count, date1, date2,branchName);
			//model.addAttribute("list", list);

			return new listExcelDownload();
		}

		@RequestMapping(value = "/mgSalesmonth.mdo")
		public ModelAndView mgSalesMarketView(/*@RequestParam(defaultValue = "title") String searchOption,
				@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage*/)
				throws Exception {
			// 레코드계산
			//int count = MgService.countArticle(searchOption, keyword);
			// 페이지 나누기처리
			/*BoardPager boardPager = new BoardPager(count, curPage);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd();*/
			
			int start = 0;
			int end= 0;
			String searchOption=null;
			String keyword=null;

			List<StatisticsVO> list = MgStatisticsService.SalesReservemonth(start, end, searchOption, keyword);
			System.out.println(list);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
		/*	map.put("count", count);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("boardPager", boardPager);*/

			ModelAndView mv = new ModelAndView();
			mv.addObject("map", map);
			mv.setViewName("body/sales/mgSalesmarket");
			System.out.println(map);

			return mv;
		}
		
		

}
