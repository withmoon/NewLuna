package com.study.luna.mg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.luna.mg.service.MgStatisticsService;

@Controller
public class MgSalesController {

	@Autowired
	public MgStatisticsService MgService;

	@RequestMapping(value="/sales_reserve.mdo",method=RequestMethod.GET)
	public String mgSalesReserveView(){
		return "body/sales/sales_reserve";
	}
	
	@RequestMapping(value="/sales_market.mdo",method=RequestMethod.GET)
	public String mgSalesMarketView(){
		return "body/sales/sales_market";
	}
	
}
