package com.study.luna.user.room.service;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface RoomService {
	//시/도 ajax 처리 쿼리
	List<String> getSido();
	List<String> getGugun(String sido);
	//미 선택시 가져오는 쿼리
	List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin);
	//방 스케줄 가져오기
	RoomInfoDTO getRoomSchedule(RoomInfoDTO romin);
	//검색에서 제외할 방 가져옴
	List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin);
}
