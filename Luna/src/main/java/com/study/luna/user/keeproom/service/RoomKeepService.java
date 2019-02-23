package com.study.luna.user.keeproom.service;

import java.util.List;

import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.dto.RoomInfoDTO;

public interface RoomKeepService {
	//룸 찜 리스트 가져오기
	List<RoomInfoDTO> getKeeplist(String id);
	//안찜
	void deletekroom(KeepRoomDTO krd);
	//찜
	void keeproom(KeepRoomDTO krd);
	//현재 방을 찜했는지 여부
	Integer getKeepStatus(KeepRoomDTO krd);
}
