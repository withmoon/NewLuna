package com.study.luna.user.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.RoomFileDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.room.dao.Impl.GetAllRoomInfoDAOImpl;
import com.study.luna.user.room.dao.Impl.GetDetailRoomInfoDAOImpl;
import com.study.luna.user.room.dao.Impl.GetExcRoomNumDAOImpl;
import com.study.luna.user.room.dao.Impl.GetGugunDAOImpl;
import com.study.luna.user.room.dao.Impl.GetRoomAllimgDAOImpl;
import com.study.luna.user.room.dao.Impl.GetRoomScheduleDAOImpl;
import com.study.luna.user.room.dao.Impl.GetSidoDAOImpl;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	GetSidoDAOImpl getSdDAOImpl;
	@Autowired
	GetGugunDAOImpl getGgDAOImpl;
	@Autowired
	GetAllRoomInfoDAOImpl grifDAOImpl;
	@Autowired
	GetRoomScheduleDAOImpl grsDAOImpl;
	@Autowired
	GetExcRoomNumDAOImpl gernDAOImpl;
	@Autowired
	GetDetailRoomInfoDAOImpl gdriDAOImpl;
	@Autowired
	GetRoomAllimgDAOImpl graiDAOImpl;
	
	@Override
	public List<String> getSido() {
		return getSdDAOImpl.getSido();
	}

	@Override
	public List<String> getGugun(String sido) {
		return getGgDAOImpl.getGugun(sido);
	}

	@Override
	public List<RoomInfoDTO> getAllRoomInfo(RoomInfoDTO romin) {
		return grifDAOImpl.getAllRoomInfo(romin);
	}

	@Override
	public RoomInfoDTO getRoomSchedule(RoomInfoDTO romin) {
		return grsDAOImpl.getRoomSchedule(romin);
	}

	@Override
	public List<RoomInfoDTO> getExcRoomNum(RoomInfoDTO romin) {
		return gernDAOImpl.getExcRoomNum(romin);
	}

	@Override
	public RoomInfoDTO getDetailRoomInfo(RoomInfoDTO romin) {
		return gdriDAOImpl.getDetailRoomInfo(romin);
	}

	@Override
	public List<RoomFileDTO> getRoomAllimg(int roomnum) {
		return graiDAOImpl.getRoomAllimg(roomnum);
	}
}
