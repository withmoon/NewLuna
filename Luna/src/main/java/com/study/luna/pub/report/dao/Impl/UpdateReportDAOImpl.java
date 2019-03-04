package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.dao.UpdateReportDAO;
@Repository
public class UpdateReportDAOImpl implements UpdateReportDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void updateReport(ReportDTO rpd) {
		sqlSession.update("reportDAO.updateReport",rpd);
	}

}
