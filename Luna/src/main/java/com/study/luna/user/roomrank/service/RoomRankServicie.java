package com.study.luna.user.roomrank.service;

import java.util.List;

import com.study.luna.user.dto.RoomRankDTO;

public interface RoomRankServicie {
	//평점과 리뷰순 방정보 구해오기
	List<RoomRankDTO> getRoomReviewRank();
}
