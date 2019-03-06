package com.study.luna.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class KeepRoomDTO {
	String id;
	int roomnum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRoomnum() {
		return roomnum;
	}
	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}
	
}
