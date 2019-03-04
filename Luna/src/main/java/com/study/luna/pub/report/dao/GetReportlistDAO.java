package com.study.luna.pub.report.dao;

import java.util.List;

import com.study.luna.pub.command.ReportDTO;

public interface GetReportlistDAO {
	List<ReportDTO> getReportlist(int start,int end,String id,ReportDTO rpd);
}
