package com.study.luna.user.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
	String branchName;
	int roomNum;
	
	String roomName; 
	String roomEx1; 
	String roomEx2; 
	String roomEx3;
	String roomEx4;
	String roomExplain;
	String roomPicture;
	String roomWarn;
	String comeRoute;
	String roomLocate;

	String reservstate;
	Date regdate;
}
