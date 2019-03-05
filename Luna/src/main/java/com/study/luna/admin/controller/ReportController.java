package com.study.luna.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {

	@RequestMapping(value="/reportboard.ado")
	public String report() {
		return "reportboard";
	}
	
	@RequestMapping(value="/reportwrite.ado")
	public String write() {
		return "reportwrite";
	}
}