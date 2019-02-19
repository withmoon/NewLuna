package com.study.luna.user.payandreserv.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.InReserveRoomDAO;

@Repository
public class InReserveRoomDAOImpl implements InReserveRoomDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void inReserveRoom(RoomReserveDTO romre) {
		sqlSession.insert("payAndReservDAO.inReserveRoom",romre);
	};
}
