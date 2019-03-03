package com.study.luna.pub.report.service;

import java.util.List;

import com.study.luna.pub.command.ReportDTO;


public interface ReportService {
	//리포터 올리기
	void insertReport(ReportDTO rpd);
	//리포트 갯수
	Integer getReportCount(ReportDTO rpd);
	//리포트 가져오기
	List<ReportDTO> getReportlist(int start,int end,String id,String searchOption,String keyword);
	
}
