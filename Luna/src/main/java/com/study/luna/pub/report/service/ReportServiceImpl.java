package com.study.luna.pub.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.dao.Impl.GetReportCountDAOImpl;
import com.study.luna.pub.report.dao.Impl.GetReportlistDAOImpl;
import com.study.luna.pub.report.dao.Impl.InsertReportDAOImpl;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	InsertReportDAOImpl irpDAOImpl;
	@Autowired
	GetReportCountDAOImpl grcDAOImpl;
	@Autowired
	GetReportlistDAOImpl grlDAOImpl;
	
	@Override
	public void insertReport(ReportDTO rpd) {
		irpDAOImpl.insertReport(rpd);
	}

	@Override
	public List<ReportDTO> getReportlist(int start, int end, String id,String searchOption,String keyword) {
		return grlDAOImpl.getReportlist(start, end, id, searchOption, keyword);
	}

	@Override
	public Integer getReportCount(ReportDTO rpd) {
		return grcDAOImpl.getReportCount(rpd);
	}

}
