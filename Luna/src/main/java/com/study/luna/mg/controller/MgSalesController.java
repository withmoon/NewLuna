package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.BoardPager;
import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.service.MgPCService;
import com.study.luna.mg.util.listExcelDownload;

@Controller
public class MgSalesController {
	// 현황보기

	@Autowired
	private MgPCService MgPCService;

	// 매출현황
	@RequestMapping(value = "/mgSales.mdo")
	public ModelAndView mgSalesView(SalesVO vo, @RequestParam(defaultValue = "") String keyword,
			@RequestParam(defaultValue = "1") int curPage) throws Exception {

		// 레코드계산
		int count = MgPCService.countArticle(keyword);

		System.out.println("키워드 :" + keyword.toString());
		System.out.println("카운트 :" + count);
		
		int page_scale = 7;
		int block_sclae = 3;
		// 페이지 나누기처리
		BoardPager boardPager = new BoardPager(count, curPage,page_scale,block_sclae);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();

		List<SalesVO> list = MgPCService.SalesList(start, end, keyword);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/presentCondition/mgSales");
		mv.addObject("map", map);

		System.out.println("mgsales 화면");
		return mv;
	}

	// 매출현황 excel 다운로드
/*	@RequestMapping(value = "/excelDownload.mdo")
	public View excelTransform(Map<String, Object> modelmap, Model model, SalesVO vo, HttpServletResponse response)
			throws Exception {
		
		 * response.setCharacterEncoding("UTF-8");
		 * response.setContentType("application/vnd.ms-excel");
		 * response.setHeader("Pragma","public"); response.setHeader("Expires","0");
		 * response.setHeader("Content-Disposition","attachment; filename = test.xls");
		 

		// List<Object> excelList = MgPCService.excelList(vo);
		// List<SalesVO> list = MgPCService.SalesList(vo);
		// ���Ϻ�ȯ Ÿ�� ������
//	 		String type = model.get("Mgsales").toString();
		// model.addAttribute("list", list);
		return new excelView();

		
		 * model.put("excelList",excelList); model.put("excelType",type);
		 
//	         return  new ModelAndView("excelView",model);    //"excelView";

		
		 * //Ÿ���� �ȱ����� ��ũ�� �������ִ°Ͱ����� String target = paramMap.get("target").toString();
		 * response.setHeader("content-disposition", "attachment; filename=������Ȳ.xmlx");
		 * List<Object> excelList = MgPCService.getExcelObject(paramMap);
		 * ModelMap.put("excelList", excelList); ModelMap.put("target", target);
		 * 
		 * System.out.println("�����ٿũ"); return "excelView";
		 
	}*/

	@RequestMapping(value = "/excelDownload.mdo")
	public View excelDownload(HttpServletRequest request, HttpServletResponse response, Model model, SalesVO vo)
			throws Exception {

		List<SalesVO> list = MgPCService.mgReserveList(vo);

		model.addAttribute("list", list);

		return new listExcelDownload();
	}

	// 예약현황
	@RequestMapping(value = "/mgReserve.mdo")
	public ModelAndView mgReserveView(SalesVO vo) {

		List<SalesVO> list = MgPCService.mgReserveList(vo);

		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("body/presentCondition/mgReserve");

		return mv;
	}

	// 방문현황
	@RequestMapping(value = "/mgVisit.mdo", method = RequestMethod.GET)
	public String mgVisitView() {
		return "body/presentCondition/mgVisit";
	}

	//
	@RequestMapping(value = "/mgRefund.mdo", method = RequestMethod.GET)
	public ModelAndView mgRefundView(SalesVO vo) {
		
		List<SalesVO> list = MgPCService.mgReserveList(vo);
 
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("body/presentCondition/mgRefund");

		return mv;
	}
}
