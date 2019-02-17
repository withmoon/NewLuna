package com.study.luna.user.room.dao;

import java.util.List;

import com.study.luna.user.dto.RoomInfoDTO;

public interface GetRoomInfoAndScheduleDAO {
	List<RoomInfoDTO> getRoomInfoAndSchedule(RoomInfoDTO romin);
}
