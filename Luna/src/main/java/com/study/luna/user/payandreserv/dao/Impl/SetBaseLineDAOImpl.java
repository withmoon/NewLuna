package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.payandreserv.dao.SetBaseLineDAO;

@Repository
public class SetBaseLineDAOImpl implements SetBaseLineDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void setBaseLine(RoomPaymentDTO dto) {
		sqlSession.update("payAndReservDAO.setBaseLine",dto);
	}

}
