package com.study.luna.user.review.service;

import java.util.List;

import com.study.luna.user.dto.RoomReviewDTO;

public interface RoomReviewService {
	//전체 리뷰 가져오기
	List<RoomReviewDTO> getRoomAllReview(int roomnum);
	//방번호에대한 총점 가져옴
	String getReviewStarAvg(int roomnum);
	//리뷰 작성
	void insertReview(RoomReviewDTO rrd);
}
