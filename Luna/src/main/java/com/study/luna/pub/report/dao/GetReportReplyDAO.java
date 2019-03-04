package com.study.luna.pub.report.dao;

import java.util.List;

import com.study.luna.pub.command.ReportReplyDTO;

public interface GetReportReplyDAO {
	//리뷰 가지고 오기
		List<ReportReplyDTO> getReportReply(int reportseq);
}
