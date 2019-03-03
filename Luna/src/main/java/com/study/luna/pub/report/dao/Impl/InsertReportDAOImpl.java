package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.dao.InsertReportDAO;
@Repository
public class InsertReportDAOImpl implements InsertReportDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertReport(ReportDTO rpd) {
		sqlSession.insert("reportDAO.insertreport",rpd);
	}

}
