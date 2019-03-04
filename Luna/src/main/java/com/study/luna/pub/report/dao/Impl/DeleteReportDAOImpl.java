package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.report.dao.DeleteReportDAO;
@Repository
public class DeleteReportDAOImpl implements DeleteReportDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void deleteReport(String seq) {
		sqlSession.delete("reportDAO.deleteReport",seq);
	}

}
