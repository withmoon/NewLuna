package com.study.luna.user.roomrank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.dto.RoomRankDTO;
import com.study.luna.user.roomrank.dao.Impl.GetNewBranchDAOImpl;
import com.study.luna.user.roomrank.dao.Impl.GetNewReviewDAOImpl;
import com.study.luna.user.roomrank.dao.Impl.GetRoomReserveRankDAOImpl;
import com.study.luna.user.roomrank.dao.Impl.GetRoomReviewRankDAOImpl;
@Service
public class RoomRankServiceImpl implements RoomRankServicie {
	
	@Autowired
	GetRoomReviewRankDAOImpl grrrDAOImpl;
	@Autowired
	GetRoomReserveRankDAOImpl grrsDAOImpl;
	@Autowired
	GetNewBranchDAOImpl gnbADAOImpl;
	@Autowired
	GetNewReviewDAOImpl gnrDAOImpl;

	@Override
	public List<RoomRankDTO> getRoomReviewRank() {
		return grrrDAOImpl.getRoomReviewRank();
	}

	@Override
	public List<RoomRankDTO> getRoomReserveRank() {
		return grrsDAOImpl.getRoomReserveRank();
	}

	@Override
	public List<MemberCommand> getNewBranch() {
		return gnbADAOImpl.getNewBranch();
	}

	@Override
	public List<RoomRankDTO> getNewReview() {
		return gnrDAOImpl.getNewReview();
	}

}
