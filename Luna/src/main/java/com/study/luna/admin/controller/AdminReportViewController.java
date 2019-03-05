package com.study.luna.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminReportViewController {
	
	@RequestMapping(value="/adminReport.ado", method=RequestMethod.GET)
	public String viewAdminReport() {
		return "report";
	}
}
