package com.study.luna.user.payandreserv.service;

import com.study.luna.user.dto.RoomReserveDTO;

public interface PayAndReserveService {
	//예약테이블에 오늘날짜를 가진 예약 row가 있나 확인
	public int checkReservStartdate(RoomReserveDTO romre);
}
