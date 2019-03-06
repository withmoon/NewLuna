package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.dao.GetReportCountDAO;
@Repository
public class GetReportCountDAOImpl implements GetReportCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getReportCount(ReportDTO rpd) {
		if(rpd.getId().equals("")) {
			return sqlSession.selectOne("reportDAO.getReportCount",rpd);
		}else {
			return sqlSession.selectOne("reportDAO.getBranchReportCount",rpd);
		}
	}

}
