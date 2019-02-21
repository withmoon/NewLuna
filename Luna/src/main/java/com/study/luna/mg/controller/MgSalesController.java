package com.study.luna.mg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.study.luna.mg.util.excelView;

@Controller
public class MgSalesController {
	//��Ȳ���� 
	
		@Autowired
		private MgPCService MgPCService;
		
		//������Ȳ
		@RequestMapping(value="/mgSales.mdo")
		public ModelAndView mgSalesView(SalesVO vo,
				@RequestParam(defaultValue="")String keyword,
				@RequestParam(defaultValue="1")int curPage) throws Exception{
			
			//���ڵ���
			int count = MgPCService.countArticle(keyword); 
			
			System.out.println("Ű���� :"+keyword.toString());
			
			//������ ������ó��
			BoardPager boardPager= new BoardPager(count,curPage);
			int start = boardPager.getPageBegin(); 
			int end = boardPager.getPageEnd(); 
			
			List<SalesVO> list = MgPCService.SalesList(start,end,keyword);
			
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("list", list); 
			map.put("count", count);
			map.put("keyword", keyword);
			map.put("boardPager", boardPager);
			
			ModelAndView mv = new ModelAndView();
			mv.setViewName("body/presentCondition/mgSales");
			mv.addObject("map",map);
			
			System.out.println("Mg_sales ��Ʈ�ѷ�");
			return mv;
		}
		
		//������Ȳ excel �ٿ�ε�
		@RequestMapping(value="/excelDownload.mdo")
		public  View excelTransform(Map<String, Object> modelmap,Model model,SalesVO vo,HttpServletResponse response) throws Exception{
		/*	
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/vnd.ms-excel");
			 response.setHeader("Pragma","public");
	         response.setHeader("Expires","0");
	         response.setHeader("Content-Disposition","attachment; filename = test.xls");*/

	         //List<Object> excelList = MgPCService.excelList(vo);
	         //List<SalesVO> list = MgPCService.SalesList(vo);
	       //���Ϻ�ȯ Ÿ�� ������
//	 		String type = model.get("Mgsales").toString();
	       //  model.addAttribute("list", list);
			return new excelView();

	 	/*	model.put("excelList",excelList); 
	 		model.put("excelType",type);
	*/
//	         return  new ModelAndView("excelView",model);    //"excelView";
			
			
			
			
			/*//Ÿ���� �ȱ����� ��ũ�� �������ִ°Ͱ�����
			String target = paramMap.get("target").toString();
			response.setHeader("content-disposition", "attachment; filename=������Ȳ.xmlx");
			List<Object> excelList = MgPCService.getExcelObject(paramMap);
			ModelMap.put("excelList", excelList);
			ModelMap.put("target", target);
			
			System.out.println("�����ٿũ");
			return "excelView";*/
		}
		
		
		//������Ȳ
		@RequestMapping(value="/mgReserve.mdo")
		public ModelAndView mgReserveView(SalesVO vo) {
			
			
			List<SalesVO> list = MgPCService.mgReserveList(vo);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("list",list);
			mv.setViewName("body/presentCondition/mgReserve");
			
			
			return mv;
		}
		
		//�湮��Ȳ
		@RequestMapping(value="/mgVisit.mdo",method=RequestMethod.GET)
		public String mgVisitView() {
			return "body/presentCondition/mgVisit";
		}
		
		//
		@RequestMapping(value="/mgRefund.mdo",method=RequestMethod.GET)
		public String mgRefundView() {
			return "body/presentCondition/mgRefund";
		}
}
