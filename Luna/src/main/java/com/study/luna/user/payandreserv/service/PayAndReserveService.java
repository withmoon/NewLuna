package com.study.luna.user.payandreserv.service;

import java.util.List;

import com.study.luna.user.dto.MyPageInfoDTO;
import com.study.luna.user.dto.RoomPaymentDTO;
import com.study.luna.user.dto.RoomReserveDTO;

public interface PayAndReserveService {
	//예약테이블에 오늘날짜를 가진 예약 row가 있나 확인
	Integer checkReservStartdate(RoomReserveDTO romre);
	//예약테이블 insert
	void inReserveRoom(RoomReserveDTO romre);
	//예약테이블 update
	void upReserveRoom(RoomReserveDTO romre);
	//예약&결제 테이블 insert
	void inRoomPayment(RoomPaymentDTO rompay);
	// 예약&결제 테이블 가져옴
	List<MyPageInfoDTO> getUserPayInfo(int start,int end,String status,String id,String startdate,String enddate);
	//카운팅
	Integer getUserPayCount(String status,String id,String startdate,String enddate);
	//사용자측에서 환불요청
	void cancleReserve(MyPageInfoDTO mpif);
}
