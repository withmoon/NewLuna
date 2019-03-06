package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.report.dao.GetReportMaxSeqDAO;
@Repository
public class GetReportMaxSeqDAOImpl implements GetReportMaxSeqDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer getReportMaxSeq() {
		return sqlSession.selectOne("reportDAO.getReportMaxSeq");
	}

}
