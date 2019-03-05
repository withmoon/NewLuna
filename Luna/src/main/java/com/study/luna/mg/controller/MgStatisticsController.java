package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.StatisticsVO;
import com.study.luna.mg.service.MgService;
import com.study.luna.mg.service.MgStatisticsService;

@Controller
public class MgStatisticsController {
	// 매출

		@Autowired
		public MgStatisticsService MgStatisticsService;
 
		// 월매출 
		@RequestMapping(value = "/mgSalesreserve.mdo")
		public ModelAndView mgSalesReserveView(/*@RequestParam(defaultValue = "date1") String searchOption,
				@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage*/)
				throws Exception {

			// 레코드계산 
			/*int count = MgStatisticsService.countArticle(searchOption, keyword);
			System.out.println("count: "+count);*/
			
			/*int page_scale = 7;
			int block_sclae = 3;
			// 페이지 나누기처리 
			BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd(); */
			int start = 0;
			int end= 0;
			String searchOption=null;
			String keyword=null;

			List<StatisticsVO> list = MgStatisticsService.SalesReserveList(start, end, searchOption, keyword);
			System.out.println(list);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
		/*	map.put("count", count);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("boardPager", boardPager);*/

			ModelAndView mv = new ModelAndView();
			mv.addObject("map", map);
			mv.setViewName("body/sales/mgSalesreserve");
			System.out.println(map);
			return mv;
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
