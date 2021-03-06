package com.study.luna.pub.report.dao.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.pub.command.ReportDTO;
import com.study.luna.pub.report.dao.GetReportlistDAO;

@Repository
public class GetReportlistDAOImpl implements GetReportlistDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReportDTO> getReportlist(int start, int end,ReportDTO rpd) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start",start);
		map.put("end", end);
		map.put("rpd",rpd);
		if(rpd.getId().equals("")) {
			return sqlSession.selectList("reportDAO.getReportlist",map);
		}else {
			return sqlSession.selectList("reportDAO.getBranchReportlist",map);
		}
	}

}
