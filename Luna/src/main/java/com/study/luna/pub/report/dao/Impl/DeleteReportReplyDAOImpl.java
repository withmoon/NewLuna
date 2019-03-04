package com.study.luna.pub.report.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.report.dao.DeleteReportReplyDAO;

@Repository
public class DeleteReportReplyDAOImpl implements DeleteReportReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void deleteReportReply(Integer seq) {
		sqlSession.delete("reportDAO.deleteReportReply",seq);
	}

}
