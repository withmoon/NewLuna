package com.study.luna.user.payandreserv.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;

public interface PayAndReserveService {
	//예약테이블에 오늘날짜를 가진 예약 row가 있나 확인
	int checkReservStartdate(RoomReserveDTO romre);
	//예약테이블 insert
	void inReserveRoom(RoomReserveDTO romre);
	//예약테이블 update
	void upReserveRoom(RoomReserveDTO romre);
	//예약&결제 테이블 insert
	void inRoomPayment(RoomPaymentDTO rompay);
	// mypage용 예약&결제 테이블 가져옴
	List<MyPageInfoDTO> getUserPayInfo(MemberCommand memcom);
}
