package com.study.luna.user.room.service;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface RoomService {
	List<String> getSido();
	List<String> getGugun(String sido);
	
	RoomInfoDTO getRoomInfo(RoomInfoDTO romin);
}
