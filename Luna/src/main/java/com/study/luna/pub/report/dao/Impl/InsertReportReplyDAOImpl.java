package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportReplyDTO;
import com.study.luna.pub.report.dao.InsertReportReplyDAO;
@Repository
public class InsertReportReplyDAOImpl implements InsertReportReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertReportReply(ReportReplyDTO rry) {
		sqlSession.insert("reportDAO.insertReportReply",rry);
	}

}
