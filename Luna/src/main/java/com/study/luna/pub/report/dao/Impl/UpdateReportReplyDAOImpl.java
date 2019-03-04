package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportReplyDTO;
import com.study.luna.pub.report.dao.UpdateReportReplyDAO;

@Repository
public class UpdateReportReplyDAOImpl implements UpdateReportReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void updateReportReply(ReportReplyDTO rry) {
		sqlSession.update("reportDAO.updateReportReply",rry);
	}

}
