package com.study.luna.user.review.dao;

import java.util.List;

import com.study.luna.user.dto.RoomReviewDTO;

public interface GetRoomAllReviewDAO {
	List<RoomReviewDTO> getRoomAllReview(int start,int end,int roomnum);
}
