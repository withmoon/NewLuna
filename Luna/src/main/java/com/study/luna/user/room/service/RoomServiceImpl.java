package com.study.luna.user.room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.luna.pub.command.MemberCommand;
import com.study.luna.user.room.dao.Impl.GetSidoDAOImpl;

@Service
public class RoomServiceImpl implements RoomService {
	@Autowired
	GetSidoDAOImpl getSdDAOImpl;
	
	@Override
	public List<MemberCommand> getSido() {
		return getSdDAOImpl.getSido();
	}

}
