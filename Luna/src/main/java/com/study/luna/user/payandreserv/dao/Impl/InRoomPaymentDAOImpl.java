package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.payandreserv.dao.InRoomPaymentDAO;
@Repository
public class InRoomPaymentDAOImpl implements InRoomPaymentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void inRoomPayment(RoomPaymentDTO rompay) {
		sqlSession.insert("payAndReservDAO.inRoomPayment",rompay);
	}

}
