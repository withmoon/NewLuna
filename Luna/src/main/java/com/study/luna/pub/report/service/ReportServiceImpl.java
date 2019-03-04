package com.study.luna.pub.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.command.ReportReplyDTO;
import com.study.luna.pub.report.dao.Impl.DeleteReportDAOImpl;
import com.study.luna.pub.report.dao.Impl.DeleteReportReplyDAOImpl;
import com.study.luna.pub.report.dao.Impl.GetReportCountDAOImpl;
import com.study.luna.pub.report.dao.Impl.GetReportReplyDAOImpl;
import com.study.luna.pub.report.dao.Impl.GetReportlistDAOImpl;
import com.study.luna.pub.report.dao.Impl.InsertReportDAOImpl;
import com.study.luna.pub.report.dao.Impl.InsertReportReplyDAOImpl;
import com.study.luna.pub.report.dao.Impl.UpdateReportDAOImpl;
import com.study.luna.pub.report.dao.Impl.UpdateReportReplyDAOImpl;
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	InsertReportDAOImpl irpDAOImpl;
	@Autowired
	GetReportCountDAOImpl grcDAOImpl;
	@Autowired
	GetReportlistDAOImpl grlDAOImpl;
	@Autowired
	UpdateReportDAOImpl urtDAOImpl;
	@Autowired
	DeleteReportDAOImpl drtDAOImpl;
	@Autowired
	GetReportReplyDAOImpl grrDAOImpl;
	@Autowired
	InsertReportReplyDAOImpl irrDAOImpl;
	@Autowired
	UpdateReportReplyDAOImpl urrDAOImpl;
	@Autowired
	DeleteReportReplyDAOImpl drrDAOImpl;
	
	@Override
	public void insertReport(ReportDTO rpd) {
		irpDAOImpl.insertReport(rpd);
	}

	@Override
	public List<ReportDTO> getReportlist(int start, int end, String id,ReportDTO rpd) {
		return grlDAOImpl.getReportlist(start, end, id,rpd);
	}

	@Override
	public Integer getReportCount(ReportDTO rpd) {
		return grcDAOImpl.getReportCount(rpd);
	}

	@Override
	public void updateReport(ReportDTO rpd) {
		urtDAOImpl.updateReport(rpd);
	}

	@Override
	public void deleteReport(String seq) {
		drtDAOImpl.deleteReport(seq);
	}

	@Override
	public List<ReportReplyDTO> getReportReply(int reportseq) {
		return grrDAOImpl.getReportReply(reportseq);
	}

	@Override
	public void insertReportReply(ReportReplyDTO rry) {
		irrDAOImpl.insertReportReply(rry);
	}

	@Override
	public void updateReportReply(ReportReplyDTO rry) {
		urrDAOImpl.updateReportReply(rry);
	}

	@Override
	public void deleteReportReply(Integer seq) {
		drrDAOImpl.deleteReportReply(seq);
	}

}
