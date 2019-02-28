package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.payandreserv.dao.GetPreYearReserveCountDAO;
@Repository
public class GetPreYearReserveCountDAOImpl implements GetPreYearReserveCountDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getPreYearReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreYearReserveCount");
	}

}
