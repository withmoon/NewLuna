package com.study.luna.user.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.RoomReviewDTO;
import com.study.luna.user.review.dao.Impl.GetReviewCountDAOImpl;
import com.study.luna.user.review.dao.Impl.GetReviewStarAvgDAOImpl;
import com.study.luna.user.review.dao.Impl.GetRoomAllReviewDAOImpl;
import com.study.luna.user.review.dao.Impl.GetUserReviewDAOImpl;
import com.study.luna.user.review.dao.Impl.InsertReviewDAOImpl;

@Service
public class RoomReviewServiceImpl implements RoomReviewService{
	@Autowired
	GetRoomAllReviewDAOImpl grarDAOImpl;
	@Autowired
	GetReviewCountDAOImpl grcDAOImpl;
	@Autowired
	GetReviewStarAvgDAOImpl grsaDAOImpl;
	@Autowired
	InsertReviewDAOImpl irvDAOImpl;
	@Autowired
	GetUserReviewDAOImpl gurDAOImpl;

	@Override
	public List<RoomReviewDTO> getRoomAllReview(int start,int end,int roomnum) {
		return grarDAOImpl.getRoomAllReview(start,end,roomnum);
	}

	@Override
	public Integer getReviewCount(int roomnum) {
		return grcDAOImpl.getReviewCount(roomnum);
	}

	@Override
	public String getReviewStarAvg(int roomnum) {
		return grsaDAOImpl.getReviewStarAvg(roomnum);
	}

	@Override
	public void insertReview(RoomReviewDTO rrd) {
		irvDAOImpl.insertReview(rrd);
	}

	@Override
	public List<String> getUserReview(String id) {
		return gurDAOImpl.getUserReview(id);
	}
}
