package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.payandreserv.dao.GetPreDayReserveCountDAO;
@Repository
public class GetPreDayReserveCountDAOImpl implements GetPreDayReserveCountDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getPreDayReserveCount() {
		return sqlSession.selectOne("payAndReservDAO.getPreDayReserveCount");
	}

}
