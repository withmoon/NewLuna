package com.study.luna.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.luna.mg.service.MgStatisticsService;

@Controller
public class MgStatisticsController {
	// 매출통계

		@Autowired
		public MgStatisticsService MgStatisticsService;

		// 월매출
		@RequestMapping(value = "/mgSalesreserve.mdo")
		public ModelAndView mgSalesReserveView(/*@RequestParam(defaultValue = "title") String searchOption,*/
				@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage)
				throws Exception {

			// 레코드계산 
			//int count = MgService.countArticle(searchOption, keyword);

			// 페이지 나누기처리
			/*BoardPager boardPager = new BoardPager(count, curPage);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd(); 

			List<StatisticsVO> list = MgService.SalesReserveList(start, end, searchOption, keyword);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("count", count);
			map.put("searchOption", searchOption);
			map.put("keyword", keyword);
			map.put("boardPager", boardPager);
	*/
			ModelAndView mv = new ModelAndView();
			//mv.addObject("map", map);
			mv.setViewName("body/sales/mgSalesreserve");

			return mv;
		}

		@RequestMapping(value = "/mgSalesmarket.mdo")
		public ModelAndView mgSalesMarketView(/*@RequestParam(defaultValue = "title") String searchOption,*/
				@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage)
				throws Exception {
			// 레코드계산
			//int count = MgService.countArticle(searchOption, keyword);
			// 페이지 나누기처리
			/*BoardPager boardPager = new BoardPager(count, curPage);
			int start = boardPager.getPageBegin();
			int end = boardPager.getPageEnd();*/
			//List<StatisticsVO> list = MgService.SalesReserveList(start, end, searchOption, keyword);

			ModelAndView mv = new ModelAndView();
			mv.setViewName("body/sales/mgSalesmarket");

			return mv;
		}

}
