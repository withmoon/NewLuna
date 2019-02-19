package com.study.luna.user.room.dao;

import java.util.List;

import com.study.luna.user.dto.RoomReviewDTO;

public interface GetRoomAllReviewDAO {
	List<RoomReviewDTO> getRoomAllReview(int roomnum);
}
