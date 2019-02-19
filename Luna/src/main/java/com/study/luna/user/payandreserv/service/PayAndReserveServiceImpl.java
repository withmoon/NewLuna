package com.study.luna.user.payandreserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.RoomReserveDTO;
import com.study.luna.user.payandreserv.dao.Impl.CheckReservStartdateDAOImpl;

@Service
public class PayAndReserveServiceImpl implements PayAndReserveService{
	@Autowired
	CheckReservStartdateDAOImpl crsdDAOImpl;

	@Override
	public int checkReservStartdate(RoomReserveDTO romre) {
		return crsdDAOImpl.checkReservStartdate(romre);
	}
	

}
