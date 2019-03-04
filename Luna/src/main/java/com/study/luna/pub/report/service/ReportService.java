package com.study.luna.pub.report.service;

import java.util.List;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.command.ReportReplyDTO;


public interface ReportService {
	//리포터 올리기
	void insertReport(ReportDTO rpd);
	//리포트 갯수
	Integer getReportCount(ReportDTO rpd);
	//리포트 가져오기
	List<ReportDTO> getReportlist(int start,int end,String id,ReportDTO rpd);
	//리포터 수정
	void updateReport(ReportDTO rpd);
	//리포트 삭제
	void deleteReport(String seq);
	//리뷰 가지고 오기
	List<ReportReplyDTO> getReportReply(int reportseq);
	//리플 달기
	void insertReportReply(ReportReplyDTO rry);
	//리뷰 수정
	void updateReportReply(ReportReplyDTO rry);
	//리뷰 삭제
	void deleteReportReply(Integer seq);
}
