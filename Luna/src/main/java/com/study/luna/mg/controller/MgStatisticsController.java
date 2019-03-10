package com.study.luna.mg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.model.StatisticsVO;
import com.study.luna.mg.service.MgStatisticsService;
import com.study.luna.mg.util.listExcelDownload;

@Controller
public class MgStatisticsController {
	// 留ㅼ텧

		@Autowired
		public MgStatisticsService MgStatisticsService;
 
		// �씪留ㅼ텧 
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
			System.out.println(branchName + "由ъ뒪�듃");
			// �젅肄붾뱶怨꾩궛
			int count = MgStatisticsService.count(date1, date2, branchName);
			System.out.println(count + "媛�");
			

			int page_scale = 10;
			int block_sclae = 5;
			// �럹�씠吏� �굹�늻湲곗쿂由�
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
		
		  //�뿊���떎�슫濡쒕뱶
		@RequestMapping(value = "/excelDownload.mdo")
		public View excelDownload(@RequestParam(defaultValue = "1") int curPage,HttpSession session,Model model)
				throws Exception {
			String date1 = (String) session.getAttribute("date1");
			String date2 = (String) session.getAttribute("date2");
			String branchName = (String) session.getAttribute("branchName");
			
			
			// �젅肄붾뱶怨꾩궛
			int count = MgStatisticsService.count(date1, date2, branchName);
			System.out.println(count + "媛�");
			
			List<SalesVO> list = MgStatisticsService.excelList(count, date1, date2,branchName);
			model.addAttribute("list", list);
			model.addAttribute("branchName",branchName);
			return new listExcelDownload();
		}

		@RequestMapping(value = "/mgSalesmonth.mdo")
		public ModelAndView mgSalesMarketView(/*@RequestParam(defaultValue = "title") String searchOption,
				@RequestParam(defaultValue = "") String keyword, @RequestParam(defaultValue = "1") int curPage*/)
				throws Exception {
			// �젅肄붾뱶怨꾩궛
			//int count = MgService.countArticle(searchOption, keyword);
			// �럹�씠吏� �굹�늻湲곗쿂由�
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
