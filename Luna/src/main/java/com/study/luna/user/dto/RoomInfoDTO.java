package com.study.luna.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomInfoDTO {
	String branchName;
	int roomNum;
	String roomName; 
	String roomEx1; 
	String roomEx2; 
	String roomEx3;
	String roomEx4;
	String roomExplain;
	//주의사항
	String roomWarn;
	//오시는길
	String comeRoute;
	//방 주소 스트링으로 받아 js에서 처리할 예정
	String roomLocate;
	//파일 이름--LookOver에서 한개씩만 쓰므로 넣어놈
	String fname;
	//시도/구군 붙여서
	String sidogugun;
	//예약 현황
	String reservstate;
	//예약 하고자하는 날짜
    String startdate;
    //제외 방번호
    String notinRoomNum;
    //지점 주소만 도로명으로
    String branchAddr1;
    
    int roomprice;
}
