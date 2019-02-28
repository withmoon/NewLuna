package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.payandreserv.dao.GetPreMonthReserveCountDAO;
@Repository
public class GetPreMonthReserveCountDAOImpl implements GetPreMonthReserveCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getPreMonthReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreMonthReserveCount");
	}

}
