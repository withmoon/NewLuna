package com.study.luna.user.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.Impl.GetGugunDAOImpl;
import com.study.luna.user.room.dao.Impl.GetRoomInfoDAOImpl;
import com.study.luna.user.room.dao.Impl.GetSidoDAOImpl;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	GetSidoDAOImpl getSdDAOImpl;
	@Autowired
	GetGugunDAOImpl getGgDAOImpl;
	@Autowired
	GetRoomInfoDAOImpl grifDAOImpl;
	
	@Override
	public List<String> getSido() {
		return getSdDAOImpl.getSido();
	}

	@Override
	public List<String> getGugun(String sido) {
		return getGgDAOImpl.getGugun(sido);
	}

	@Override
	public RoomInfoDTO getRoomInfo(RoomInfoDTO romin) {
		return grifDAOImpl.getRoomInfo(romin);
	}

}
