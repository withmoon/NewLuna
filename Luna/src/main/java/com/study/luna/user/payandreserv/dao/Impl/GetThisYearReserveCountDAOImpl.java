package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.payandreserv.dao.GetThisYearReserveCountDAO;
@Repository
public class GetThisYearReserveCountDAOImpl implements GetThisYearReserveCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getThisYearReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getThisYearReserveCount");
	}

}
