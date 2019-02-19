package com.study.luna.user.room.dao;

import java.util.List;

import com.study.luna.user.dto.RoomFileDTO;

public interface GetRoomAllimgDAO {
	List<RoomFileDTO> getRoomAllimg(int roomnum);
}
