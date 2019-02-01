package com.study.luna.mg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MgStatisticsController {

	@RequestMapping(value="/MgSales.mdo",method=RequestMethod.GET)
	public String mgSalesView() {
		return "body/presentCondition/Mg_sales";
	}
	@RequestMapping(value="/MgReserve.mdo",method=RequestMethod.GET)
	public String mgReserveView() {
		return "body/presentCondition/Mg_reserve";
	}
	@RequestMapping(value="/MgVisit.mdo",method=RequestMethod.GET)
	public String mgVisitView() {
		return "body/presentCondition/Mg_visit";
	}
	
	@RequestMapping(value="/MgRefund.mdo",method=RequestMethod.GET)
	public String mgRefundView() {
		return "body/presentCondition/Mg_refund";
	}
}
