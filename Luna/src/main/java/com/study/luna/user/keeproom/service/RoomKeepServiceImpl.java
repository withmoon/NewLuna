package com.study.luna.user.keeproom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.user.dto.KeepRoomDTO;
import com.study.luna.user.dto.RoomInfoDTO;
import com.study.luna.user.keeproom.dao.Impl.DeletekroomDAOImpl;
import com.study.luna.user.keeproom.dao.Impl.GetKeepStatusDAOImpl;
import com.study.luna.user.keeproom.dao.Impl.GetKeeplistDAOImpl;
import com.study.luna.user.keeproom.dao.Impl.KeeproomDAOImpl;

@Service
public class RoomKeepServiceImpl implements RoomKeepService {
	
	@Autowired
	GetKeeplistDAOImpl gklDAOImpl;
	@Autowired
	KeeproomDAOImpl krDAOImpl;
	@Autowired
	DeletekroomDAOImpl dkrDAOImpl;
	@Autowired
	GetKeepStatusDAOImpl gksDAOImpl;
	
	
	@Override
	public List<RoomInfoDTO> getKeeplist(String id) {
		return gklDAOImpl.getKeeplist(id);
	}


	@Override
	public void deletekroom(KeepRoomDTO krd) {
		dkrDAOImpl.deletekroom(krd);
		
	}


	@Override
	public void keeproom(KeepRoomDTO krd) {
		krDAOImpl.keeproom(krd);
	}


	@Override
	public Integer getKeepStatus(KeepRoomDTO krd) {
		return gksDAOImpl.getKeepStatus(krd);
	}

}
