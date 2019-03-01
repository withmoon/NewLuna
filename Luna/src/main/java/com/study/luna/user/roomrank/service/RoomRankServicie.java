package com.study.luna.user.roomrank.service;

import java.util.List;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.RoomRankDTO;

public interface RoomRankServicie {
	//평점과 리뷰순 방정보 구해오기
	List<RoomRankDTO> getRoomReviewRank();
	//예약순으로 방정보 구해오기
	List<RoomRankDTO> getRoomReserveRank();
	//최신 지점 가져오기
	List<MemberCommand> getNewBranch();
	//최신 리뷰 6개 가져오기
	List<RoomRankDTO> getNewReview();
}
