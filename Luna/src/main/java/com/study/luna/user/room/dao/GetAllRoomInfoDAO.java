package com.study.luna.user.room.dao;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface GetAllRoomInfoDAO {
	List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin);
}
