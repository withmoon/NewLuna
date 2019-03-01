package com.study.luna.user.roomrank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.RoomRankDTO;
import com.study.luna.user.roomrank.dao.Impl.GetRoomReviewRankDAOImpl;
@Service
public class RoomRankServiceImpl implements RoomRankServicie {
	
	@Autowired
	GetRoomReviewRankDAOImpl grrrDAOImpl;

	@Override
	public List<RoomRankDTO> getRoomReviewRank() {
		return grrrDAOImpl.getRoomReviewRank();
	}

}
