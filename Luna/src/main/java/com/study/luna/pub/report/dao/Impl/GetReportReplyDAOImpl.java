package com.study.luna.pub.report.dao.Impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportReplyDTO;
import com.study.luna.pub.report.dao.GetReportReplyDAO;

@Repository
public class GetReportReplyDAOImpl implements GetReportReplyDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReportReplyDTO> getReportReply(int reportseq) {
		return sqlSession.selectList("reportDAO.getReportReply",reportseq);
	}

}
