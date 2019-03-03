package com.study.luna.payandreserv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.payandreserv.service.PayAndReserveService;

@Controller
public class GetTermSalesController {
	
	@Autowired
	PayAndReserveService prser;
	
	@RequestMapping(value="/getTermSales.do",method = RequestMethod.GET)
	public @ResponseBody List<RoomPaymentDTO> getTermSales(@RequestParam(value="paid_at_start",defaultValue = "") String paid_at_start
														,@RequestParam(value="paid_at_end",defaultValue = "") String paid_at_end){
		List<RoomPaymentDTO> termSaleslist=prser.getTermSales(paid_at_start,paid_at_end);
		
		return termSaleslist;
	}
}
