package com.study.luna.user.room.service;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface RoomService {
	//시/도 ajax 처리 쿼리
	List<String> getSido();
	List<String> getGugun(String sido);
	//미 선택시 가져오는 쿼리
	List<RoomInfoDTO> getRoomInfo(RoomInfoDTO romin);
	// 시도 선택시 가져오는 쿼리
	List<RoomInfoDTO> getRoomInfoAndSchedule(RoomInfoDTO romin);
}
