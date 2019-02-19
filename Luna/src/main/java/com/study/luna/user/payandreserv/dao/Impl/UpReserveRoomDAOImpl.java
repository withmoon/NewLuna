package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.UpReserveRoomDAO;
@Repository
public class UpReserveRoomDAOImpl implements UpReserveRoomDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void upReserveRoom(RoomReserveDTO romre) {
		sqlSession.update("payAndReservDAO.upReserveRoom",romre);
	}

}
