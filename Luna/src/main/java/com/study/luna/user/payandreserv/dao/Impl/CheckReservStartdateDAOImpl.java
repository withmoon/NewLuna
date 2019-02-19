package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.CheckReservStartdateDAO;

@Repository
public class CheckReservStartdateDAOImpl implements CheckReservStartdateDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Integer checkReservStartdate(RoomReserveDTO romre) {
		return sqlSession.selectOne("payAndReservDAO.checkReservStartdate",romre);
	}

}
