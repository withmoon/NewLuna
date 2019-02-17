package com.study.luna.mg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.study.luna.mg.model.SalesVO;
import com.study.luna.mg.service.MgPCService;
import com.study.luna.mg.util.excelView;

@Controller
public class MgStatisticsController {
	//��Ȳ����
	
	@Autowired
	private MgPCService MgPCService;
	
	//������Ȳ
	@RequestMapping(value="/mgSales.mdo",method=RequestMethod.GET)
	public ModelAndView mgSalesView(SalesVO vo) throws Exception {
		List<SalesVO> list = MgPCService.SalesList(vo);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("body/presentCondition/mgSales");
		mv.addObject("list",list);
		
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
         List<SalesVO> list = MgPCService.SalesList(vo);
       //���Ϻ�ȯ Ÿ�� ������
// 		String type = model.get("Mgsales").toString();
         model.addAttribute("list", list);
		return new excelView();

 	/*	model.put("excelList",excelList); 
 		model.put("excelType",type);
*/
//         return  new ModelAndView("excelView",model);    //"excelView";
		
		
		
		
		/*//Ÿ���� �ȱ����� ��ũ�� �������ִ°Ͱ�����
		String target = paramMap.get("target").toString();
		response.setHeader("content-disposition", "attachment; filename=������Ȳ.xmlx");
		List<Object> excelList = MgPCService.getExcelObject(paramMap);
		ModelMap.put("excelList", excelList);
		ModelMap.put("target", target);
		
		System.out.println("�����ٿũ");
		return "excelView";*/
	}
	
	
	//
	@RequestMapping(value="/mgReserve.mdo",method=RequestMethod.GET)
	public String mgReserveView() {
		return "body/presentCondition/mgReserve";
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
